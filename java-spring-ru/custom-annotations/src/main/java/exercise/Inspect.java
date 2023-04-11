package exercise;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

// BEGIN
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
// Чтобы аннотация принимала аргумент, в интерфейсе нужно определить метод с именем параметра
// Вызов этого метода вернёт значение параметра, переданного в аннотацию
public @interface Inspect {
    String level() default "debug";
}

// END
