package exercise;

import java.util.List;
import java.util.ArrayList;

class Implementations {
    public static List<Integer> right(List<Integer> elements, int count) {
        int length = elements.size();
        List<Integer> result = new ArrayList<>();
        if (count > length) {
            count = length;
        }
        for (int i = 0; i < count; i++) {
            result.add(elements.get(i));
        }
        return result;
    }

    public static List<Integer> wrong1(List<Integer> elements, int count) {
        int length = elements.size();
        List<Integer> result = right(elements, count);
        if (length == 0) {
            result.add(0);
        }
        return result;
    }

    public static List<Integer> wrong2(List<Integer> elements, int count) {
        int length = elements.size();
        List<Integer> result = right(elements, count);

        if (length != 0 && count > length) {
            result.add(100);
        }

        return result;
    }

    public static List<Integer> wrong3(List<Integer> elements, int count) {
        int length = elements.size();
        List<Integer> result = right(elements, count);

        if (length != 0 && count <= length) {
            result.add(10);
        }

        return result;
    }
}
