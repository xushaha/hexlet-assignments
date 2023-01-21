package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class Validator {

    public static List<String> validate(Object object) throws IllegalAccessException {
        List<String> list = new ArrayList<>();

        for (Field field : object.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (notNull != null) {
                field.setAccessible(true);
                try {
            Object value = field.get(object);
            if (value == null) {
                list.add(field.getName());
            }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }


    public static Map<String, List<String>> advancedValidate(Object object) throws IllegalAccessException {

        Map<String, List<String>> result = new HashMap<>();

        for (Field field : object.getClass().getDeclaredFields()) {

            NotNull notNull = field.getAnnotation(NotNull.class);
            MinLength minLength = field.getAnnotation(MinLength.class);

            field.setAccessible(true);

            if (notNull != null && field.get(object) == null) {
                result.put(field.getName(), List.of("can't be null"));
            } else if (minLength != null) {
                String value = (String) field.get(object);
                if (value.length() < minLength.minLength()) {
                    result.put(field.getName(), List.of("length less than " + minLength.minLength()));
                }
            }
        }
        return result;
    }
}

// END

