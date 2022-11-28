package exercise;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        int n1 = 5;
        List<Integer> expectedList1 = Arrays.asList(1, 2, 3, 4, 5);


        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(5);
        list2.add(10);
        list2.add(11);
        list2.add(26);
        list2.add(6);
        int n2 = 8;
        List<Integer> expectedList2 = Arrays.asList(3, 5, 10, 11, 26, 6);


        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(6);
        list3.add(13);
        int n3 = 0;
        List<Integer> expectedList3 = Arrays.asList();
        
        assertThat(App.take(list1, n1)).isEqualTo(expectedList1);
        assertThat(App.take(list2, n2)).isEqualTo(expectedList2);
        assertThat(App.take(list3, n3)).isEqualTo(expectedList3);

        // END
    }
}
