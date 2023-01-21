package exercise;

import exercise.demo.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvParserExample {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        try {
            System.out.println(getParsedObject(User.class, "./exercises/reflections/example.txt"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static <T> List<T> getParsedObject(Class<T> clazz, String path) throws IOException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        List<T> list = new ArrayList<>();
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        Map<String, Integer> fields = new HashMap<>();
        String line = null;
        for (int i = 0; (line = bufferedReader.readLine()) != null; i++) {
            String[] values = line.split(",");
            if (i == 0) {
                for (int k = 0; k < values.length; k++) {
                    fields.put(values[k], k);
                }
            } else {
                T t = clazz.getConstructor().newInstance();
                for (Map.Entry<String, Integer> field : fields.entrySet()) {
                    for (Field f : clazz.getDeclaredFields()) {
                        if (f.getName().equals(field.getKey())) {
                            f.setAccessible(true);
                            f.set(t, values[field.getValue()]);
                        }
                    }
                }
                list.add(t);
            }
        }
        return list;
    }
}
