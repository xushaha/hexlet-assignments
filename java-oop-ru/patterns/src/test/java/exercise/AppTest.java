package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;


class TcpTest {

    @Test
    void testConnect1()  {
        TcpConnection connection = new TcpConnection("33.22.11.44", 80);
        connection.connect();
        assertThat(connection.getCurrentState()).isEqualTo("connected");
        connection.write("one");
        connection.write("two");
        connection.disconnect();
        assertThat(connection.getCurrentState()).isEqualTo("disconnected");
    }

    @Test
    void testConnect2() throws Exception {
        TcpConnection connection = new TcpConnection("33.22.11.44", 80);
        connection.connect();
        String result = tapSystemOut(() -> {
            connection.connect();
        });
        assertThat(result.contains("Error"))
            .as("Try to connect when connection already established. Message must contains word Error")
            .isTrue();
    }

    @Test
    void testConnect3() throws Exception {
        TcpConnection connection = new TcpConnection("33.22.11.44", 80);
        connection.connect();
        connection.disconnect();
        String result = tapSystemOut(() -> {
            connection.disconnect();
        });
        assertThat(result.contains("Error"))
            .as("Try to disconnect when connection disconnected. Message must contains word Error")
            .isTrue();
    }

    @Test
    void testConnect4() throws Exception {
        TcpConnection connection = new TcpConnection("33.22.11.44", 80);
        connection.connect();
        connection.disconnect();
        String result = tapSystemOut(() -> {
            connection.write("one");
        });
        assertThat(result.contains("Error"))
            .as("Try to write to disconnected connection. Message must contains word Error")
            .isTrue();
    }
}
