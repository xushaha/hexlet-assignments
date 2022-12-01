package exercise;

import org.apache.commons.lang3.StringUtils;
import java.util.List;

// BEGIN
class App {
    public static int getCountOfFreeEmails(List<String> emails) {

        return (int) emails.stream()
        .filter(email -> (StringUtils.contains(email, "@yandex.ru"))
                || (StringUtils.contains(email, "@gmail.com"))
                || (StringUtils.contains(email, "@hotmail.com")))
        .count();

        }
}
// END
