package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {
//        // intro
//        List<Integer> list = List.of(1, 2, 3, 4, 5);
//        System.out.println(getEvenNumbers(list));
//        System.out.println(getEvenNumbersPro(list));
//
        //examples
//
//        // Numbers
//        List<Integer> numbers = List.of(1, -1, -8, 11, 20, 30, 44);
//        numbers.stream()
//                .filter(num -> num > 0)
//                .forEach(num -> {
//                    System.out.println(num);
//                });
//
//        int result = numbers.stream()
//                .filter(num -> num > 0)
//                .min((x, y) -> Integer.compare(x, y))
//                .orElse(0);
//
//        System.out.println(result);
//
        // 1 вариант
//        int sum1 = numbers.stream()
//                .reduce((x, y) -> x + y)
//                .orElse(0);
//        System.out.println("SUM: " + sum1);
//
//        // 2 вариант
//        int sum2 = numbers.stream()
//                .mapToInt(num -> num)
//                .sum();
//        System.out.println("SUM2: " + sum2);
//
//        double avg = numbers.stream()
//                .mapToInt(x -> x)
//                .average()
//                .orElse(0);
//
//        System.out.println("AVG value: " + avg);
//
//        // String
//
        List<String> names = List.of("Egor", "Max", "Ivan", "Petr", "Patric", "");
//        names = names.stream()
//                .filter(name -> StringUtils.isNotBlank(name))
//                .map(name -> name.toUpperCase())
//                .collect(Collectors.toList());
//        System.out.println("Modified names list: " + names);
//
//        //vs
//        List<String> names2 = new ArrayList<>();
//        for (String name: names) {
//            if (StringUtils.isNotBlank(name)) {
//                names2.add(name.toUpperCase());
//            }
//        }
//        System.out.println(names2);
//
        // вариант 1
//        long amount = names.stream()
//                .filter(name -> StringUtils.isNotBlank(name))
//                .filter(name -> name.startsWith("P"))
//                .count();
//        System.out.println("Amount of names starts with P: " + amount);
//
//        // вариант 2
//        long amount2 = names.stream()
//                .filter(name -> StringUtils.isNotBlank(name))
//                .filter(name -> name.startsWith("P"))
//                .collect(Collectors.counting());
//
//        System.out.println("Amount of names starts with P [2]: " + amount2);
//
//
//        // Objects
        List<User> users = getUsersList();
//        // а если users null???
//        if (users != null) {
//            Map<Boolean, List<User>> isOnlineMap = users.stream()
//                    .filter(user -> Objects.nonNull(user))
//                    .collect(Collectors.groupingBy(user -> user.isOnline(), Collectors.toList()));
//            System.out.println(isOnlineMap);
//        } else
//            System.out.println("List is null");
//
//        if (users != null) {
//            Map<Boolean, List<User>> isAdultMap = users.stream()
//                    .collect(Collectors.groupingBy(user -> isAdult(user), Collectors.toList()));
//            System.out.println(isAdultMap);
//        } else
//            System.out.println("List is null");
//
        if (users != null) {
            Map<Integer, List<User>> ageMap = users.stream()
                    .filter(user -> isAdult(user))
                    .collect(Collectors.groupingBy(user -> user.getAge(), Collectors.toList()));
            System.out.println(ageMap);
        } else {
            System.out.println("List is null");
        }
    }

    private static boolean isAdult(User user) {
        return user.getAge() >= 18;
    }

    private static List<User> getUsersList() {
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setId(1);
        user1.setName("Egor");
        user1.setOnline(true);
        user1.setAge(10);
        users.add(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setName("Max");
        user2.setOnline(false);
        user2.setAge(20);
        users.add(user2);

        User user3 = new User();
        user3.setId(3);
        user3.setName("Petr");
        user3.setOnline(true);
        user3.setAge(20);
        users.add(user3);

        User user4 = new User();
        user4.setId(4);
        user4.setName("Henry");
        user4.setOnline(true);
        user4.setAge(50);
        users.add(user4);

        User user5 = new User();
        user5.setId(5);
        user5.setName("Robert");
        user5.setOnline(false);
        user5.setAge(17);
        users.add(user5);

        return users;
    }

    private static List<Integer> getEvenNumbers(List<Integer> input) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : input) {
            if (i % 2 == 0) {
                list.add(i);
            }
        }
        return list;
    }

    private static List<Integer> getEvenNumbersPro(List<Integer> input) {
        return input.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
    }
}
