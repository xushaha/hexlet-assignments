package exercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AppTest {
    @Test
    void testBuildList() {
        String[] emails = {
            "info@gmail.com",
            "info@yandex.ru",
            "info@hotmail.com",
            "mk@host.com",
            "support@hexlet.io",
            "key@yandex.ru",
            "sergey@gmail.com",
            "vovan@gmail.com",
            "vovan@hotmail.com"
        };
        List<String> emailsList = Arrays.asList(emails);
        assertThat(App.getCountOfFreeEmails(emailsList)).isEqualTo(7);
    }

    @Test
    void testBuildList2() {
        String[] emails = {
            "info@yandex.ru",
            "mk@host.com",
            "support@hexlet.io",
            "key@yandex.ru",
            "sergey@gmail.com",
            "vovan@gmail.com",
            "support.yandex.ru@host.com",
            "support.yandex.ru@hexlet.io"
        };
        List<String> emailsList = Arrays.asList(emails);
        assertThat(App.getCountOfFreeEmails(emailsList)).isEqualTo(4);
    }

    @Test
    void testBuildList3() {
        String[] emails = {
            "mk@host.com",
            "support@hexlet.io",
            "support.yandex.ru@host.com",
            "support.yandex.ru@hexlet.io"
        };
        List<String> emailsList = Arrays.asList(emails);
        assertThat(App.getCountOfFreeEmails(emailsList)).isEqualTo(0);
    }
}
