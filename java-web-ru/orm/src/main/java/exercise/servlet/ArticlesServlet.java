package exercise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import io.ebean.PagedList;

import exercise.TemplateEngineUtil;
import exercise.domain.Article;
import exercise.domain.Category;
// Эти классы создаются автоматически для каждой сущности
// К названию добавляется префикс Q
import exercise.domain.query.QArticle;
import exercise.domain.query.QCategory;

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
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void showArticles(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException, ServletException {

        int articlesPerPage = 10;
        String page = request.getParameter("page");
        int normalizedPage = page == null ? 1 : Integer.parseInt(page);
        int offset = (normalizedPage - 1) * articlesPerPage;

        // BEGIN

        PagedList<Article> pagedArticles = new QArticle()
                // Устанавливаем смещение
                .setFirstRow(offset)
                // Устанавливаем максимальное количество записей в результате
                .setMaxRows(articlesPerPage)
                // Задаём сортировку по имени компании
                .orderBy().id.asc()
                // Получаем список PagedList, который представляет одну страницу результата
                .findPagedList();

        List<Article> articles = pagedArticles.getList();
        request.setAttribute("articles", articles);

        // END
        request.setAttribute("page", normalizedPage);
        TemplateEngineUtil.render("articles/index.html", request, response);
    }

    private void showArticle(HttpServletRequest request,
                         HttpServletResponse response)
                 throws IOException, ServletException {

        long id = Long.parseLong(getId(request));

        // BEGIN
        /*Допишите метод showAricle(), который выводит страницу просмотра статьи.
        При помощи ORM получите из базы данных статью Article
        по её id и установите её в качестве значения для атрибута "article".*/
        Article article = new QArticle()
                .id.equalTo(id)
                .findOne();
        request.setAttribute("article", article);
        // END
        TemplateEngineUtil.render("articles/show.html", request, response);
    }

    private void newArticle(HttpServletRequest request,
                            HttpServletResponse response)
                    throws IOException, ServletException {

        // BEGIN
        /*Получите список List всех категорий Category и установите его в качестве значения для атрибута "categories".*/
        List<Category> categories = new QCategory().findList();
        request.setAttribute("categories", categories);
        // END
        TemplateEngineUtil.render("articles/new.html", request, response);
    }

    private void createArticle(HttpServletRequest request,
                         HttpServletResponse response)
                 throws IOException, ServletException {

        HttpSession session = request.getSession();
        String title = request.getParameter("title");
        String body = request.getParameter("body");
        String categoryId = request.getParameter("categoryId");

        // BEGIN
        /*Допишите метод createArticle(), который создаёт новую статью и добавляет её в базу данных.
        Для создания статьи используйте созданный ранее конструктор.*/
        long id = Long.parseLong(categoryId);
        Category category = new QCategory()
                .id.equalTo(id)
                .findOne();
        Article newArticle = new Article(title, body, category);
        newArticle.save();
        // END

        session.setAttribute("flash", "Статья успешно создана");
        response.sendRedirect("/articles");
    }
}
