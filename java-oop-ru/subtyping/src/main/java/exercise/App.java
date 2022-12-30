package exercise;
import java.util.Map;
import java.util.stream.Collectors;


// BEGIN
public class App {

        public static void swapKeyValue(KeyValueStorage storage){
                Map<String, String> input = storage.toMap();
                for (Map.Entry<String, String> input1: input.entrySet()) {
                        var oldKey= input1.getKey();
                        var oldValue= input1.getValue();
                        storage.set(oldValue, oldKey);
                        storage.unset(oldKey);
                }
        }
}
// END
