package exercise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.List;

import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List<Map<String, String>> getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        String filePath = "src/main/resources/users.json";
        Path path = Path.of(filePath).toAbsolutePath().normalize();
        String content = Files.readString(path);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<>(){});
        // END
    }

    private void showUsers(HttpServletRequest request, HttpServletResponse response)
                throws IOException {

        // BEGIN
        List<Map<String, String>> userList = getUsers();
        StringBuilder body = new StringBuilder();

        body.append("""
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                        <title>Example application | Users</title>
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
                        rel="stylesheet"
                        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                        crossorigin="anonymous">
                    </head>
                    <body>
                    <table>
                      <thead>
                        <tr>
                          <th>id</th>
                          <th>fullName</th>
                        </tr>
                      </thead>
                      <tbody>
                """);

        for (Map<String, String> user : userList) {
            body.append("<tr>" +
                          "<td>" + user.get("id") + "</td>" +
                          "<td>" +
                    "<a href=\"/users/"+ user.get("id") + "\">" + user.get("firstName") + " " + user.get("lastName") +
                            "</a></td>" +
                        "</tr>"
                    );
        }

        body.append("""
                    </tbody>
                    </table>
                    </body>
                </html>
                """);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(body);
        // END
    }

   /*В методе showUser() реализуйте вывод всех полей пользователя. Вывод организуйте как вам удобно
   (проще всего использовать таблицу). Идентификатор пользователя id передаётся в метод третьим аргументом.
   Если пользователь с переданным идентификатором не существует, сайт должен вернуть ошибку
   404 (страница с HTTP кодом 404) и текстом "Not found".*/

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        List<Map<String, String>> userList = getUsers();
        StringBuilder body = new StringBuilder();
        Map<String, String> currentUser = getUser(userList, id);

        if (currentUser == null) {
            response.sendError(404, "Not found");
        } else {
            body.append("""
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                        <title>Example application | Users</title>
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
                        rel="stylesheet"
                        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                        crossorigin="anonymous">
                    </head>
                    <body>
                    <table>
                      <thead>
                        <tr>
                          <th>id</th>
                          <th>firstName</th>
                          <th>lastName</th>
                          <th>email</th>
                        </tr>
                      </thead>
                      <tbody>
                """);

                body.append("<tr>" +
                        "<td>" + currentUser.get("id") + "</td>" +
                        "<td>" + currentUser.get("firstName") + "</td>" +
                        "<td>" + currentUser.get("lastName") + "</td>" +
                        "<td>" + currentUser.get("email") + "</td>" +
                        "</tr>"
                );


            body.append("""
                    </tbody>
                    </table>
                    </body>
                </html>
                """);

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(body);

        }

        // END
    }

    private Map<String, String> getUser(List<Map<String, String>> userList, String id) throws JsonProcessingException, IOException {
        for (Map<String, String> user: userList) {
            if (user.get("id").equals(id)) {
                return user;
            }
        }
        return null;
    }
}
