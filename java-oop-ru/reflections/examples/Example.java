package exercise;

import exercise.demo.RandomNumber;
import exercise.demo.User;

import java.lang.reflect.Field;
import java.util.Random;

public class Example {
    public static void main(String[] args) {
        User user = new User();
//        System.out.println(user);
//        System.out.println(user.getClass());
//
////        // доступ к private полю
////        // получаем все поля класса
//        Field[] fields = user.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println(field);
//        }
////
//        // устанавливаем значение поля name без setter-а
//        try {
//            Field field = user.getClass().getDeclaredField("name");
//            field.setAccessible(true);
//            field.set(user, "Egor");
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        System.out.println(user);
////
//        // устанавливаем значение поля id без setter-а
//        try {
//            Field field = user.getClass().getDeclaredField("id");
//            field.setAccessible(true);
//            field.set(user, 1);
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        System.out.println(user);

//        // вызов метода
//
//        // выводим все доступные методы класса
//        for (Method method: user.getClass().getMethods()) {
//            System.out.println(method);
//        }
//        System.out.println("===========================");
////
//        // выводим все методы класса
//        for (Method method : user.getClass().getDeclaredMethods()) {
//            System.out.println(method);
//        }
////
//        // вызов доступного метода
//        try {
//            Method toString = user.getClass().getDeclaredMethod("toString");
//            System.out.println(toString.invoke(user));
//        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
////
////        // вызов недоступного метода
////
//        try {
//            Method getGreetingMsg = user.getClass().getDeclaredMethod("getGreetingMsg");
//            getGreetingMsg.setAccessible(true);
//            System.out.println(getGreetingMsg.invoke(user));
//        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//        // конструкторы
//        for (Constructor constructor: user.getClass().getConstructors()) {
//            System.out.println(constructor);
//        }
////
//        try {
//            Class[] params = {String.class, String.class, String.class};
//            Constructor constructor = user.getClass().getConstructor(params);
//            User u = (User) constructor.newInstance("2", "Max", "49");
//            System.out.println(u);
//        } catch (NoSuchMethodException | InstantiationException |
//        IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }

        // аннотации
        User user3 = new User();
        for (Field field : user3.getClass().getDeclaredFields()) {
            RandomNumber randomNumber = field.getAnnotation(RandomNumber.class);
            if (randomNumber != null) {
                Random random = new Random();
                int randomValue = random.nextInt(randomNumber.max() - randomNumber.min() + 1) + randomNumber.min();
                try {
                    field.setAccessible(true);
                    field.set(user3, String.valueOf(randomValue));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(user3);
    }
}
