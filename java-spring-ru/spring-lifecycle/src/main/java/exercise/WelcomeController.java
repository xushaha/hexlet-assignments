package exercise;

import exercise.daytimes.Daytime;
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
