package exercise;

import exercise.daytimes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// BEGIN
@RestController
public class WelcomeController {

    // Получаем из контекста
    @Autowired
    Daytime daytime;

    @Autowired
    Meal meal;


    @GetMapping("/daytime")
    public String root() {
        return "It is " + MyApplicationConfig.time() + " now. Enjoy your " + meal.getMealForDaytime(daytime.getName());
    }
}

// END


/*  Добавьте необходимые импорты

    Получите из контекста приложения объект текущего времени суток и объект класса Meal

    Добавьте в контроллер метод, который обрабатывает GET запросы на адрес /daytime.
    Метод должен пожелать приятного аппетита в зависимости от времени суток.
    Например, если сейчас утро, запрос должен вернуть строку "It is morning now. Enjoy your breakfast".
    При составлении фразы используйте методы полученных из контекста объектов.
*/