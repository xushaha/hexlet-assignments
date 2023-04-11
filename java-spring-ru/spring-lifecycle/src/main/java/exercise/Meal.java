package exercise;

import javax.annotation.PostConstruct;

// BEGIN
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Аннотация @Configuration указывает, что класс содержит методы, создающие бины
@Configuration
// END
public class Meal {
    public String getMealForDaytime(String daytime) {

        switch (daytime) {
            case "morning":
                return "breakfast";
            case "day":
                return "lunch";
            case "evening":
                return "dinner";
            default:
                return "nothing :)";
        }
    }

    // Для самостоятельной работы
    // BEGIN
    @PostConstruct
    public void init() {
        System.out.println("Init bean meal");
    }
    // END
}

/* Запустите приложение и изучите вывод в консоли. Посмотрите, какие бины создаются приложения,
и в каком порядке происходит вызов методов. Найдите в выводе наш бин meal. Вывод будет выглядеть примерно так:
Called postProcessBeforeInitialization for bean: meal
Init bean Meal
Called postProcessAfterInitialization for bean: meal
*/
