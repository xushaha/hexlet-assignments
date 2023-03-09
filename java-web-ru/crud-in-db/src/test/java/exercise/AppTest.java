package exercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import static org.assertj.core.api.Assertions.assertThat;

import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.LifecycleException;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.ParseException;
import java.io.IOException;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;

class AppTest {
    private static int port;
    private static Connection connection;
    private static String hostname = "localhost";
    private static Tomcat app;
    private static String baseUrl;

    private static String getFileContent(String fileName) throws IOException {
        Path logPath = Paths.get(fileName).toAbsolutePath().normalize();
        return Files.readString(logPath);
    }

    private static boolean isDatabaseHas(String title) throws SQLException {
        String query = "SELECT * FROM articles WHERE title=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, title);
        ResultSet rs = statement.executeQuery();
        return rs.first();
    }

    @BeforeAll
    public static void setup() throws LifecycleException, SQLException, IOException {
        connection = DriverManager.getConnection("jdbc:h2:mem:");
        app = App.getApp(0, connection);
        app.start();
        port = app.getConnector().getLocalPort();
        baseUrl = "http://" + hostname + ":" + port;

        Statement statement = connection.createStatement();
        String initSql = getFileContent("init.sql");
        statement.execute(initSql);
    }

    @Test
    void testArticles() throws IOException, ParseException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(baseUrl + "/articles");
        CloseableHttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);

        assertThat(response.getCode()).isEqualTo(200);
        assertThat(content).contains("The Last Enemy");
        assertThat(content).doesNotContain("East of Eden");

        HttpGet request2 = new HttpGet(baseUrl + "/articles?page=2");
        CloseableHttpResponse response2 = client.execute(request2);

        HttpEntity entity2 = response2.getEntity();
        String content2 = EntityUtils.toString(entity2);

        assertThat(response2.getCode()).isEqualTo(200);

        assertThat(content2).contains("?page=1");
        assertThat(content2).contains("?page=3");

        assertThat(content2).contains("Death Be Not Proud");
        assertThat(content2).doesNotContain("A Time of Gifts");
    }

    @Test
    void testArticle() throws IOException, ParseException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(baseUrl + "/articles/20");
        CloseableHttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);

        assertThat(response.getCode()).isEqualTo(200);
        assertThat(content).contains("That Good Night");
        assertThat(content).contains("Summer will end soon enough, and childhood as well");
    }

    @Test
    void testNewArticle() throws IOException {
        HttpGet request = new HttpGet(baseUrl + "/articles/new");
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(request);

        assertThat(response.getCode()).isEqualTo(200);
    }

    @Test
    void testCreateArticle() throws IOException, ParseException, SQLException {
        HttpPost postRequest = new HttpPost(baseUrl + "/articles");

        List<NameValuePair> params = new ArrayList<>();

        params.add(new BasicNameValuePair("title", "My new test article"));
        params.add(new BasicNameValuePair("body", "Text of article"));
        postRequest.setEntity(new UrlEncodedFormEntity(params));

        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(postRequest);

        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        assertThat(content).contains("Статья успешно создана");

        assertThat(response.getCode()).isEqualTo(200);
        assertThat(isDatabaseHas("My new test article")).isTrue();
    }

    @Test
    void testEditArticle() throws IOException, ParseException {
        HttpGet request = new HttpGet(baseUrl + "/articles/7/edit");
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);

        assertThat(response.getCode()).isEqualTo(200);
        assertThat(content).contains("A Passage to India");
        assertThat(content).contains("Power is a curious thing");
    }

    @Test
    void testUpdateArticle() throws IOException, ParseException, SQLException {
        HttpPost postRequest = new HttpPost(baseUrl + "/articles/1/edit");

        List<NameValuePair> params = new ArrayList<>();

        params.add(new BasicNameValuePair("title", "The Man Within-lalalalala"));
        params.add(new BasicNameValuePair("body", "Updated article body"));
        postRequest.setEntity(new UrlEncodedFormEntity(params));

        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(postRequest);

        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        assertThat(content).contains("Статья успешно изменена");

        assertThat(response.getCode()).isEqualTo(200);
        assertThat(isDatabaseHas("The Man Within-lalalalala")).isTrue();
    }

    @Test
    void testDeleteArticle() throws IOException, ParseException {
        HttpGet request = new HttpGet(baseUrl + "/articles/3/delete");
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);

        assertThat(response.getCode()).isEqualTo(200);
        assertThat(content).contains("The Lathe of Heaven");
    }

    @Test
    void testDestroyArticle() throws IOException, ParseException, SQLException {
        HttpPost postRequest = new HttpPost(baseUrl + "/articles/5/delete");
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(postRequest);

        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        assertThat(content).contains("Статья успешно удалена");

        assertThat(response.getCode()).isEqualTo(200);
        assertThat(isDatabaseHas("Eyeless in Gaza")).isFalse();
    }

    @AfterAll
    public static void tearDown() throws LifecycleException, IOException, SQLException {
        connection.close();
        app.stop();
    }
}
