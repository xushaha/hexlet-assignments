package exercise;

import java.util.List;
import java.util.Map;

public class Util {
    /**
     * Никто не запрещает передавать List (любую коллекцию) в качестве аргумента метода.
     * @param users
     * @return users amount
     */
    public static int getAmountOfUsers(List<User> users) {
        return users.size();
    }

    public static int getAmountOfBooks(Map<String, List<String>> map) {
        int result = 0;
        for (Map.Entry<String, List<String>> authorAndBooks: map.entrySet()) {
            result = result + authorAndBooks.getValue().size();
        }
        return result;
    }

    /**
     * Нельзя без <T>.
     * Обощенные классы — это хорошо, но что если нам в одном классе нужны разные generics
     * @param list
     * @param element
     * @param <T>
     * @return element index
     */
    public static <T> int findElementIndex(List<T> list, T element) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(element)) {
                return i;
            }
        }
        return 0;
    }

}
