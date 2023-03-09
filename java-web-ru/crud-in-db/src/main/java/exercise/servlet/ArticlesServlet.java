package exercise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import exercise.TemplateEngineUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ArticlesServlet extends HttpServlet {

    private String getId(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            return null;
        }
        String[] pathParts = pathInfo.split("/");
        return ArrayUtils.get(pathParts, 1, null);
    }

    private String getAction(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            return "list";
        }
        String[] pathParts = pathInfo.split("/");
        return ArrayUtils.get(pathParts, 2, getId(request));
    }

    private Map<String, String> getArticleById(String id, Connection connection) throws SQLException {
        String query = "SELECT * FROM articles WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, id);
        ResultSet rs = statement.executeQuery();

        if (!rs.first()) {
            return null;
        }

        return Map.of(
            "id", id,
            "title", rs.getString("title"),
            "body", rs.getString("body")
        );
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String action = getAction(request);

        switch (action) {
            case "list":
                showArticles(request, response);
                break;
            case "new":
                newArticle(request, response);
                break;
            case "edit":
                editArticle(request, response);
                break;
            case "delete":
                deleteArticle(request, response);
                break;
            default:
                showArticle(request, response);
                break;
        }
    }

    @Override
    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String action = getAction(request);

        switch (action) {
            case "list":
                createArticle(request, response);
                break;
            case "edit":
                updateArticle(request, response);
                break;
            case "delete":
                destroyArticle(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void showArticles(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");

        List<Map<String, String>> articles = new ArrayList<>();

        int articlesPerPage = 10;
        String page = request.getParameter("page");
        int normalizedPage = page == null ? 1 : Integer.parseInt(page);
        int offset = (normalizedPage - 1) * articlesPerPage;

        String query = "SELECT * FROM articles ORDER BY id LIMIT ? OFFSET ?";

        try {
            // Методы для работы с базой данных могут выбросить исключение,
            // которое нужно обработать
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, articlesPerPage);
            statement.setInt(2, offset);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                articles.add(Map.of(
                    "id", rs.getString("id"),
                    "title", rs.getString("title"),
                    "body", rs.getString("body")
                    )
                );
            }

        } catch (SQLException e) {
            // Если в процессе работы с базой было выброшено исключение SQLException,
            // нужно отправить в ответе код ошибки 500
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        request.setAttribute("articles", articles);
        request.setAttribute("page", normalizedPage);
        TemplateEngineUtil.render("articles/index.html", request, response);
    }

    private void showArticle(HttpServletRequest request,
                         HttpServletResponse response)
                 throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");

        String id = getId(request);

        Map<String, String> article;

        try {
            article = getArticleById(id, connection);
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        request.setAttribute("article", article);
        TemplateEngineUtil.render("articles/show.html", request, response);
    }

    private void newArticle(HttpServletRequest request,
                            HttpServletResponse response)
                    throws IOException, ServletException {

        TemplateEngineUtil.render("articles/new.html", request, response);
    }

    private void createArticle(HttpServletRequest request,
                         HttpServletResponse response)
                 throws IOException, ServletException {

        HttpSession session = request.getSession();
        String title = request.getParameter("title");
        String body = request.getParameter("body");

        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");

        // BEGIN
        // Добавление новой статьи в базу. Формируем запрос
        String query = "INSERT INTO articles (title, body) VALUES (?, ?)";

        try {
            // Получаем запрос к базе данных
            // Запрос представлен классом PreparedStatement
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, title);
            statement.setString(2, body);

            // Выполняем запрос в базу данных
            statement.execute();

        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        // END

        session.setAttribute("flash", "Статья успешно создана");
        response.sendRedirect("/articles");
    }

    private void editArticle(HttpServletRequest request,
                         HttpServletResponse response)
                 throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");

        String id = getId(request);

        // BEGIN
        Map<String, String> article;

        try {
            article = getArticleById(id, connection);
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        // END

        request.setAttribute("article", article);
        TemplateEngineUtil.render("articles/edit.html", request, response);
    }

    private void updateArticle(HttpServletRequest request,
                         HttpServletResponse response)
                 throws IOException, ServletException {

        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");

        String id = getId(request);
        String title = request.getParameter("title");
        String body = request.getParameter("body");

        // BEGIN
        //обновляет данные статьи в базе
        // Составляем запрос, который обновит данные компании с указанным id
        String query2 = "UPDATE articles SET title=?, body = ? WHERE id=?";

        try {
            // Получаем запрос
            PreparedStatement statement = connection.prepareStatement(query2);
            statement.setString(1, title);
            statement.setString(2, body);
            statement.setString(3, id);
            // Выполняем запрос
            statement.execute();

        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        // END

        session.setAttribute("flash", "Статья успешно изменена");
        response.sendRedirect("/articles");
    }

    private void deleteArticle(HttpServletRequest request,
                         HttpServletResponse response)
                 throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");

        String id = getId(request);

        // BEGIN
        //выводит страницу с подтверждением удаления статьи. Текст подтверждения должен содержать
        // название статьи, поэтому в шаблон передаются данные удаляемой статьи.
        // Вам понадобится получить эти данные из базы и поместить в переменную article с типом Map<String, String>.

        // Формируем запрос на удаление компании из базы по ее идентификатору
        Map<String, String> article;

        try {
            article = getArticleById(id, connection);
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        // END

        request.setAttribute("article", article);
        TemplateEngineUtil.render("articles/delete.html", request, response);
    }

    private void destroyArticle(HttpServletRequest request,
                         HttpServletResponse response)
                 throws IOException, ServletException {

        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");

        String id = getId(request);

        // BEGIN
        String query = "DELETE FROM articles WHERE id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.execute();

        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }


        // END

        session.setAttribute("flash", "Статья успешно удалена");
        response.sendRedirect("/articles");
    }
}
