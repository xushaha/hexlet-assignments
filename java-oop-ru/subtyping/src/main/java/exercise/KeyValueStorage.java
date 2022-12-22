package exercise;

import java.util.Map;

interface KeyValueStorage {
    void set(String key, String value);
    void unset(String key);
    String get(String key, String defaultValue);
    Map<String, String> toMap();
}
