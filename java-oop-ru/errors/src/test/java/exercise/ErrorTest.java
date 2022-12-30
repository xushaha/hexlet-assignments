package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ErrorTest {
    @Test
    void negativeRadiusException() {
        var error = new NegativeRadiusException("");
        assertThat(error).isInstanceOf(Exception.class);
    }
}
