package exercise;

import java.util.Comparator;
import java.util.List;

public class Example {
    private static List<User> users = List.of(new User(1, "Max"));


    public static void main(String[] args) {
        // продвинутые стримы
//
//        users.stream()
//                .forEach(System.out::println);
//


//        List<User> users2 = List.of(new User(3, "Nick"));
//
//        Map<Integer, String> namesMap = Stream.concat(users.stream(), users2.stream())
//                .collect(Collectors.toMap(User::getId, User::getName, (v1, v2) -> v1));
//        System.out.println(namesMap);

//
//        User firstUser = users.stream()
//                .sorted(Comparator.comparing(x -> x.getName().length()))
//                .findFirst()
//                .orElse(null);
//
//        System.out.println(firstUser);
//
//
        User firstUserAgain = users.stream()
                .sorted(Comparator.comparingInt(x -> x.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("no users found"));
//
//        System.out.println(firstUserAgain);
//
//        // throws
        Integer id = getUserId("Ivan");
        System.out.println(id);
    }

    private static Integer getUserId(String name) throws IllegalArgumentException {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user.getId();
            }
        }
        throw new IllegalArgumentException("No user with such name!");
    }
}
