package exercise;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MinLength {
    // Чтобы аннотация принимала параметр, в интерфейсе нужно определить метод.
    // Вызов этого метода на экземпляре аннотации вернет значение, переданное аннотации при её использовании.
    // Если значение не было передано, вызов метода вернет значение по умолчанию.
    int minLength() default 3;
}
