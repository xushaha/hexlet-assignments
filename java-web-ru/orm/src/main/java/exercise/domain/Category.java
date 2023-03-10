package exercise.domain;

import io.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.CascadeType;

/*
Изучите класс Category, который представляет собой модель категории.
Обратите внимание, что модель наследуется от класса io.ebean.Model.
Благодаря этому на модели можно вызывать метод save() для сохранения данных в базу.
Изучите аннотации, которыми отмечены класс и поля класса.
*/


// Указываем, что класс является моделью
@Entity //Specifies that the class is an entity.
public class Category extends Model {

    // Указываем, что поле является первичным ключом
    // Значение будет генерироваться автоматически
    @Id //Specifies the primary key of an entity.
    private long id;

    private String name;

    // Задаём связь "один ко многим"
    // Указываем тип данных Article для свойства
    // Тем самым указываем связанную сущность
    @OneToMany(cascade = CascadeType.ALL)
    private List<Article> articles;

    public Category(String name) {
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Article> getArticles() {
        return this.articles;
    }
}
