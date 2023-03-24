package exercise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// BEGIN
@RestController
public class WelcomeController {
    //Реализуйте обработчик, который будет обрабатывать GET-запросы к корневой странице
    // приложения по пути /. Запрос на эту страницу должен вернуть строку "Welcome to Spring".

    @GetMapping("/")
    // Обработчик
    // Привязываем параметр запроса к параметру метода
    // и задаём значение по умолчанию
    public String welcome() {
        return "Welcome to Spring";
    }

    // Сопоставляем GET запрос на адрес /users с обработчиком
    @GetMapping("/hello")
    // Обработчик
    // Привязываем параметр запроса к параметру метода
    // и задаём значение по умолчанию
    public String helloUser(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello, %s!", name);
    }


}
// END
