package exercise;
import java.util.Map;
import java.util.stream.Collectors;


// BEGIN
public class App {

        public static void swapKeyValue(KeyValueStorage storage){
                Map<String, String> input = storage.toMap();
                input.entrySet().stream()
                        .collect(Collectors.toMap(s->s.getKey(), s->s.getValue()));
                storage = new InMemoryKV(input);
        }
}
// END
