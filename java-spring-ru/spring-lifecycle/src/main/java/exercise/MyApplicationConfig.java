package exercise;

import java.time.LocalDateTime;

// BEGIN
import exercise.daytimes.Day;
import exercise.daytimes.Daytime;
import exercise.daytimes.Evening;
import exercise.daytimes.Morning;
import exercise.daytimes.Night;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Аннотация @Configuration указывает, что класс содержит методы, создающие бины
@Configuration
public class MyApplicationConfig {

    // Аннотация @Bean указывает, что метод возвращает бин, который нужно добавить в контекст
    // Spring будет вызывать методы этого класса, помеченные аннотацией @Bean
    // и полученные объекты добавлять в контекст

    @Bean
    // В методе мы сами создаем новый экземпляр класса и возвращаем его
    // Внутри метода можно использовать любую логику, например условия
    // Будет создан и добавлен в контекст бин с именем метода - "getCat"
    public static Daytime time() {

        int hour = LocalDateTime.now().getHour();

        if (hour >= 6 && hour < 12) {
            return new Morning();
        } else if (hour >= 12 && hour < 18) {
            return new Day();
        } else if (hour >= 18 && hour < 23) {
            return new Evening();
        } else {
            return new Night();
        }

    }

}

// END
