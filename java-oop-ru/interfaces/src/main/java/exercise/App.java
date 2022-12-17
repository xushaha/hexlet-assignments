package exercise;

import java.util.List;
import java.util.stream.Collectors;


// BEGIN
public class App {

       public static List<String> buildAppartmentsList(List<Home> appartments, int n) {
               return appartments.stream()
                       .sorted((home, another) -> home.compareTo(another))
                       .limit(n)
                       .map(home1 -> home1.toString())
                       .collect(Collectors.toList());
       }
}
// END
