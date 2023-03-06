package exercise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import java.util.Map;

import static exercise.App.getUsers;
import exercise.Users;

public class SessionServlet extends HttpServlet {

    private Users users = getUsers();
    /*Изучите содержимое методов doGet() и doPost().

    Обратите внимание, как организована обработка сервлетом запросов
    по нескольким адресам и при помощи какого метода происходит получение части URL.*/

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {

        if (request.getRequestURI().equals("/login")) {
            showLoginPage(request, response);
            return;
        }

        response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {

        switch (request.getRequestURI()) {
            case "/login" -> login(request, response);
            case "/logout" -> logout(request, response);
            default -> response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void showLoginPage(HttpServletRequest request,
                               HttpServletResponse response)
                 throws IOException, ServletException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request, response);
    }



    private void login(HttpServletRequest request,
                               HttpServletResponse response)
                 throws IOException, ServletException {

        // BEGIN
            // Получение сессии
            HttpSession session = request.getSession();
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            // Получаем пользователя по логину
            Map<String, String> user = users.findByEmail(email);

            // Если пользователь существует и введен верный пароль, установите в сессию атрибуты "userId"
            // со значением id пользователя и "flash" со значением "Вы успешно вошли", затем выполните редирект на главную страницу /
            if (!(user == null) && (password.equals("password"))) {
                // Установка атрибутов сессии
                // Вход в систему сводится к записи данных пользователя в сессию
                String id = request.getParameter("id");
                session.setAttribute("userId", id);
                // Механизм работы флеш-сообщений тоже основан на сессии
                // Устанавливаем в сессию атрибут с текстом сообщения
                // Далее мы сможем получить эти данные в шаблонах
                session.setAttribute("flash", "Вы успешно вошли");
                // Выполняем редирект на главную страницу
                response.sendRedirect("/");
            } else {
                //Если пользователь не существует в системе или пароль введен неверно,
                // установите в сессию атрибут "flash" со значением "Неверные логин или пароль",
                // установите код ответа 422 и передайте управление в файл /login.jsp.
                // При ошибке входа поле формы email должно быть заполнено введенными данными.
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
                request.setAttribute("email", email);
                session.setAttribute("flash", "Неверные логин или пароль");
                response.setStatus(422);
                requestDispatcher.forward(request, response);
                return;
            }
        // END
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) //обрабатывает POST-запросы по пути /logout
                 throws IOException {

        // BEGIN
        HttpSession session = request.getSession();
        // реализуйте выход пользователя из системы. Чтобы вывести пользователя из системы,
        //нужно удалить из сессии его данные.
        session.removeAttribute("userId");
        // После вывода пользователя из системы установите в сессию атрибут "flash" со значением "Вы успешно вышли"
        //и выполните редирект на главную страницу /
        session.setAttribute("flash", "Вы успешно вышли");
        response.sendRedirect("/");
        // END
    }
}
