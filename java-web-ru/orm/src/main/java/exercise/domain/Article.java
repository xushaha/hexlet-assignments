package exercise.domain;

import io.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import io.ebean.annotation.NotNull;

@Entity
public class Article extends Model {

    @Id
    private long id;

    private String title;

    @Lob
    private String body;

    @ManyToOne
    @NotNull
    private Category category;

    // BEGIN
    /*Допишите модель статьи Article.
    Создайте в классе конструктор, который принимает в качестве аргументов название статьи, её содержание и категорию статьи.
    Category category = ... // получаем категорию из базы
    String title = "New article";
    String body = "Text of article";
    Article article = new Article(title, body, category);
*/
    public Article(String title, String body, Category category) {
        this.title = title;
        this.body = body;
        this.category = category;
    }
    // Создайте геттеры для получения значения всех полей: getId(), getTitle(), getBody(), getCategory().
    public long getId() {
       return id;
    }
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }
    public Category getCategory() {
        return category;
    }
    // END
}
