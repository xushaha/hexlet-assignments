package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {

        // <тег атрибут1="значение1" атрибут2="значение2">

        String name;
        Map <String, String> attributes;
        
        public Tag (String name, Map <String, String> attributes) {
                this.name = name;
                this.attributes = attributes;
        }


        public String getName() {
                return this.name;
        }

        public Map <String, String> getAttributes() {
                return this.attributes;
        }
}
// END
