package exercise;

import lombok.*;

// BEGIN
@Getter
@AllArgsConstructor
@Value
// END
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
