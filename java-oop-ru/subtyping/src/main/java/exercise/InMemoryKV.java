package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class InMemoryKV implements KeyValueStorage{

        private final Map<String, String> storage;

        public InMemoryKV(Map<String, String> data) {
                this.storage = new HashMap<>();
                this.storage.putAll(data);
        }

        /*добавляет в словарь новое значение по указанному ключу (или меняет значение, если ключ уже существует).*/
        @Override
        public void set(String key, String value) {
                this.storage.put(key, value);
        }

        /*удаляет из словаря значение по переданному ключу*/
        @Override
        public void unset(String key) {
                this.storage.remove(key);
        }

        /*Возвращает значение по указанному ключу. Если такого ключа в словаре нет, возвращает значение по умолчанию.*/
        @Override
        public String get(String key, String defaultValue) {
                return this.storage.getOrDefault(key, defaultValue);
        }

        /*возвращает базу данных в виде словаря Map*/
        @Override
        public Map<String, String> toMap() {
                return new HashMap<>(this.storage);
        }
}
// END
