// public class CompaniesServlet extends HttpServlet {

//     @Override
//     public void doPost(HttpServletRequest request,
//                       HttpServletResponse response)
//                 throws IOException, ServletException {

//         // Получаем соединение с базой данных
//         ServletContext context = request.getServletContext();
//         Connection connection = (Connection) context.getAttribute("dbConnection");

//         // Добавление новой компании в базу

//         // Формируем запрос
//         String query = "INSERT INTO companies (name) VALUES (?)";
//         String name = "New company";

//         // Если в процессе работы выброшено исключение SQLException,
//         // Нужно установить в ответе статус 500
//         try {
//             PreparedStatement statement = connection.prepareStatement(query);
//             statement.setString(1, name);
//             statement.execute();

//         } catch (SQLException e) {
//             response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//             return;
//         }

//         // Изменение данных компании в базе

//         String query2 = "UPDATE companies SET name=? WHERE id=?";
//         String id = "5";
//         String newName = "Company2"

//         try {
//             PreparedStatement statement = connection.prepareStatement(query2);
//             statement.setString(1, newName);
//             statement.execute();

//         } catch (SQLException e) {
//             response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//             return;
//         }

//         // Удаление данных компании из базы

//         String query = "DELETE FROM companies WHERE id=?";

//         try {
//             PreparedStatement statement = connection.prepareStatement(query);
//             statement.setString(1, id);
//             statement.execute();

//         } catch (SQLException e) {
//             response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//             return;
//         }
//     }
// }
