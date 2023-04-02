package exercise.controller;

import exercise.model.User;
import exercise.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Кодировщик BCrypt
    // Используйте для хеширования пароля
    @Autowired
    private PasswordEncoder encoder;

    @GetMapping(path = "")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    // BEGIN
    @PostMapping(path = "")
    public User createUsers(@RequestBody User user) {
        String rawPassword = user.getPassword();
        String password = encoder.encode(rawPassword);
        user.setPassword(password );
        return userRepository.save(user);
    }
    // END
}



/*
Создайте в контроллере метод, который обрабатывает POST запросы на адрес /users и регистрирует нового пользователя.
Пароль пользователя должен храниться в базе данных в зашифрованном виде.
Для этого перед тем, как сохранить его в базу, пароль нужно хешировать.

Нам нужно разрешить регистрацию всем пользователям. Дополните конфигурацию
в файле src/main/java/exercise/WebSecurityConfig.java Укажите, что выполнить POST запрос на адрес
/users могут все пользователи, в том числе и не авторизованные.

Снова запустите приложение и создайте нового пользователя.
Попробуйте авторизоваться, используя имя и пароль только что созданного пользователя.
*/