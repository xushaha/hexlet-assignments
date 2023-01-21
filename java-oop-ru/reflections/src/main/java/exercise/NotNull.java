package exercise;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

// Аннотация задаётся описанием соответствующего интерфейса с ключевым словом @interface
// Саму аннотацию можно пометить несколькими аннотациями

// Аннотация @Target указывает, что именно можно пометить этой аннотацией. В данном случае это поля класса.
@Target(value = ElementType.FIELD)

// Аннотация @Retention указывает жизненный цикл аннотации.
// RUNTIME указывает, что она будет также видна и в процессе выполнения.
// Это нужно для того, чтобы мы могли в процессе выполнения обращаться к классу через рефлексию.
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
}
