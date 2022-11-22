package exercise;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AppTest {
    @Test
    void testGetWordsCount() {
        String sentence1 = "word text dog apple word apple word";
        Map actual1 = App.getWordCount(sentence1);
        Map expected1 = new HashMap();
        expected1.put("word", 3);
        expected1.put("apple", 2);
        expected1.put("text", 1);
        expected1.put("dog", 1);
        assertThat(actual1).containsExactlyInAnyOrderEntriesOf(expected1);

        String sentence2 = "";
        Map actual2 = App.getWordCount(sentence2);
        assertThat(actual2).isEmpty();

    }

    @Test
    void testToString() {
        String sentence1 = "word text cat apple word map apple word";
        Map wordCount1 = App.getWordCount(sentence1);
        String actual1 = App.toString(wordCount1).trim();
        String[] expectedSubstrings1 = {"  apple: 2\n", "  cat: 1\n", "  text: 1\n", "  word: 3\n", "  map: 1\n"};
        assertThat(actual1).contains(expectedSubstrings1);
        assertThat(actual1).hasSize(52);

        String sentence2 = "word text cat apple word apple word";
        Map wordCount2 = App.getWordCount(sentence2);
        String actual2 = App.toString(wordCount2).trim();
        String[] expectedSubstrings2 = {"  apple: 2\n", "  cat: 1\n", "  text: 1\n", "  word: 3\n"};
        assertThat(actual2).contains(expectedSubstrings2);
        assertThat(actual2).hasSize(43);

        String sentence3 = "";
        Map wordCount3 = App.getWordCount(sentence3);
        String actual3 = App.toString(wordCount3);
        assertThat(actual3.trim()).isEqualTo("{}");
    }
}
