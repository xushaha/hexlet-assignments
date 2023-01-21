package exercise.demo;

import java.lang.reflect.Field;
import java.util.Random;

public class User {
    @RandomNumber(min = 5, max = 1000)
    private String id;
    private String name;
    private String age;

    public User() {
        handleFields();
    }

    private void handleFields() {
        for (Field field: this.getClass().getDeclaredFields()) {
            RandomNumber randomNumber = field.getAnnotation(RandomNumber.class);
            if (randomNumber != null) {
                Random random = new Random();
                int randomValue = random.nextInt(randomNumber.max() - randomNumber.min() + 1) + randomNumber.min();
                try {
                    field.setAccessible(true);
                    field.set(this, String.valueOf(randomValue));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public User(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", age='" + age + '\''
                + '}';
    }

    private String getGreetingMsg() {
        return "Hello, dear " + name + "!";
    }
}
