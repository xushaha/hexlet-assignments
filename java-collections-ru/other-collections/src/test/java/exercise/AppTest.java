package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;

class AppTest {
    @Test
    void testGenDiff1() {
        Map<String, Object> data1 = new HashMap<>();
        Map<String, Object> data2 = new HashMap<>();
        Map<String, String> expected = new HashMap<>();
        assertThat(App.genDiff(data1, data2)).isEqualTo(expected);
    }

    @Test
    void testGenDiff2() {
        Map<String, Object> data1 = new HashMap<>();
        data1.put("two", "own");
        Map<String, Object> data2 = new HashMap<>();
        data2.put("one", "eon");
        Map<String, String> expected = new LinkedHashMap<>();
        expected.put("one", "added");
        expected.put("two", "deleted");

        assertThat(App.genDiff(data1, data2)).isEqualTo(expected);
    }

    @Test
    void testGenDiff3() {
        Map<String, Object> data1 = new HashMap<>(
            Map.of("two", "own", "one", "one")
        );
        Map<String, Object> data2 = new HashMap<>(
            Map.of("one", "eon", "two", "two")
        );
        Map<String, String> expected = new LinkedHashMap<>();
        expected.put("one", "changed");
        expected.put("two", "changed");

        assertThat(App.genDiff(data1, data2)).isEqualTo(expected);
    }

    @Test
    void testGenDiff4() {
        Map<String, Object> data1 = new HashMap<>();
        data1.put("two", "own");
        Map<String, Object> data2 = new HashMap<>();
        Map<String, String> expected = new LinkedHashMap<>();
        expected.put("two", "deleted");

        assertThat(App.genDiff(data1, data2)).isEqualTo(expected);
    }

    @Test
    void testGenDiff5() {
        Map<String, Object> data1 = new HashMap<>();
        Map<String, Object> data2 = new HashMap<>();
        data2.put("one", "neo");
        Map<String, String> expected = new LinkedHashMap<>();
        expected.put("one", "added");

        assertThat(App.genDiff(data1, data2)).isEqualTo(expected);
    }

    @Test
    void testGenDiff6() {
        Map<String, Object> data1 = new HashMap<>(
            Map.of("one", "eon", "two", "two", "four", true, "abs", 'h')
        );
        Map<String, Object> data2 = new HashMap<>(
            Map.of("two", "own", "zero", 4, "four", true)
        );
        System.out.println(data1);
        System.out.println(data2);
        Map<String, String> expected = new LinkedHashMap<>();
        expected.put("abs", "deleted");
        expected.put("four", "unchanged");
        expected.put("one", "deleted");
        expected.put("two", "changed");
        expected.put("zero", "added");

        assertThat(App.genDiff(data1, data2)).isEqualTo(expected);
    }
}
