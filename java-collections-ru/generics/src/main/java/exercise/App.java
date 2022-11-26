package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> bookList, Map<String, String> filter) {

        List<Map<String, String>> result = new ArrayList<>();

        boolean check = false;

        for(Map<String, String> book : bookList) {

            for (Map.Entry<String, String> criteria : filter.entrySet())

                if (book.containsKey(criteria.getKey())) {
                    if (book.containsValue(criteria.getValue())) {
                        check = true;

                    } else {
                        check = false;
                        break;
                    }

                }
            if (check) {
                result.add(book);
            }
        }

        return result;
    }
}
//END



