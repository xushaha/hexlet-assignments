package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
       /* Конструктор класса принимает два аргумента: Путь до файла, в котором будут храниться данные (строка)
        Словарь Map, который будет начальным значением базы данных. Ключи и значения в словаре также представлены строками.*/
        private final String path;
        private final Map<String, String> initialValue;
        public FileKV(String path, Map<String, String> initialValue) {
                this.path = path;
                this.initialValue = initialValue;
        }

        // KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        // Получение значения по ключу storage.get("key", "default"); // "value"

        @Override
        public void set(String key, String value) {

        }

        @Override
        public void unset(String key) {

        }

        @Override
        public String get(String key, String defaultValue) {
                return null;
        }

        @Override
        public Map<String, String> toMap() {
                return null;
        }

/*        class Utils {
                public static String serialize(Map<String, String> map) {
                        ObjectMapper mapper = new ObjectMapper();
                        String json = "";
                        try {
                                json = mapper.writeValueAsString(map);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                        return json;
                }

                public static Map<String, String> unserialize(String json) {
                        ObjectMapper mapper = new ObjectMapper();
                        Map<String, String> data = new HashMap<>();
                        try {
                                data = mapper.readValue(json, Map.class);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                        return data;
                }

                public static String readFile(String path) {
                        Path fullPath = Paths.get(path).toAbsolutePath().normalize();
                        String content = "";
                        try {
                                content = Files.readString(fullPath);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                        return content;
                }

                public static void writeFile(String path, String content) {
                        Path fullPath = Paths.get(path).toAbsolutePath().normalize();
                        try {
                                Files.writeString(fullPath, content, StandardOpenOption.WRITE);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }*/




}
// END
