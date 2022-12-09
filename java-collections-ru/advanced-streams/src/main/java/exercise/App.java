package exercise;

import java.util.stream.Collectors;
import java.util.stream.Stream;



// BEGIN
public class App {
       public static String getForwardedVariables(String config) {
               
              return Stream.of(config.split("\n"))
                       .filter(element -> element.startsWith("environment"))
                       .map(element -> element.replaceAll("environment=\"", ""))
                       .map(element -> element.substring(0, element.length() - 1))
                       .flatMap(element -> Stream.of(element.split(",")))
                       .filter(element -> element.startsWith("X_FORWARDED"))
                       .map(element -> element.replaceAll("X_FORWARDED_", ""))
                       .collect(Collectors.joining(","));

        }

}


//END
