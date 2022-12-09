package exercise;

// import java.util.ArrayList;
// import java.util.List;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AppTest {

    private static String data1;
    private static String data2;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
        .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        data1 = readFixture("s1.conf");
        data2 = readFixture("s2.conf");
    }

    @Test
    void testGetForvardedVariables() {

        String result1 = App.getForwardedVariables(data1);
        String expected1 = "variable=value";
        assertThat(result1).isEqualTo(expected1);

        String result2 = App.getForwardedVariables(data2);
        String expected2 = "var1=111,var2=123,var3=value,mail=tirion@google.com,HOME=/home/tirion";
        assertThat(result2).isEqualTo(expected2);
    }
}
