package exercise.controller;
import exercise.UserNotFoundException;
import exercise.model.User;
import exercise.model.QUser;
import exercise.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Зависимости для самостоятельной работы
// import org.springframework.data.querydsl.binding.QuerydslPredicate;
// import com.querydsl.core.types.Predicate;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    // BEGIN
    @Operation(summary = "Get users by their first name or last name")
    // Контейнер для аннотаций @ApiResponse.
    // Используется в случае, если нужно указать более одного ответа
    @ApiResponses(value = {
            // Указываем, что операция вернет ответ с кодом 200 в случае успешного выполнения
            @ApiResponse(responseCode = "200", description = "List of users found"),

    })
    @GetMapping(path = "")
    public Iterable<User> getUserByName(@Parameter(description = "Data user to found with")
                                            @RequestParam (required = false) String firstName,
                                            @RequestParam (required = false) String lastName) {
        if (firstName == null & lastName == null) {
            return this.userRepository.findAll();
        } else if (firstName != null & lastName == null) {
            return this.userRepository.findAll(
                    QUser.user.firstName.containsIgnoreCase(firstName));
        } else if (firstName == null & lastName != null) {
            return this.userRepository.findAll(
                    QUser.user.lastName.containsIgnoreCase(lastName));
        } else {
            return this.userRepository.findAll(
                    QUser.user.firstName.containsIgnoreCase(firstName)
                            .and(QUser.user.lastName.containsIgnoreCase(lastName)));
        }

    }
    // END
}