package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {

        private String body;
        private List<Tag> children;

        PairedTag (String name, Map <String, String> attributes, String body, List<Tag> children) {
                super(name, attributes);
                this.body = body;
                this.children = children;
        }

        public String toString() {
                StringBuilder output = new StringBuilder("<" + this.name);

                for(Map.Entry<String, String> item : attributes.entrySet()){
                        output.append(" ")
                                .append(item.getKey()).append("=")
                                .append("\"")
                                .append(item.getValue())
                                .append("\"");
                }
                output.append(">")
                .append(this.body);

                for (Tag tag : children) {
                        output.append(tag);
                }
                output.append("</" + name + ">");
                return output.toString();
        }

}
// END
