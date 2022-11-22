package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
        public static Map getWordCount(String sentence) {
                String[] words = sentence.split(" ");
                Map<String, Integer> map = new HashMap<>();

                if (sentence.length() == 0) {
                        return map;
                } else {
                for (int i = 0; i < words.length; i++) {

                        if (!map.containsKey(words[i])) {
                                map.put(words[i], 1);
                        } else {
                                map.put(words[i], map.get(words[i]) + 1);
                        }
                }

                return map;
                }

        }


        public static String toString(Map<String, Integer> map) {
                String result = "{\n";

                if (map.isEmpty()) {
                        return "{}";
                } else {
                        for (Map.Entry<String, Integer> words : map.entrySet()) {
                                result += "  " + words.getKey() + ": " + words.getValue() + "\n";
                        }
                        result += "}";
                }
                return result;
        }
}
//END
