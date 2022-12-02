package exercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {
        @Test
        void testImage1() {
                String[][] image = {
                        {"*", "*", "*", "*"},
                        {"*", " ", " ", "*"},
                        {"*", " ", " ", "*"},
                        {"*", "*", "*", "*"},
                };

                String[][] doubleImage = {
                        {"*", "*", "*", "*", "*", "*", "*", "*"},
                        {"*", "*", "*", "*", "*", "*", "*", "*"},
                        {"*", "*", " ", " ", " ", " ", "*", "*"},
                        {"*", "*", " ", " ", " ", " ", "*", "*"},
                        {"*", "*", " ", " ", " ", " ", "*", "*"},
                        {"*", "*", " ", " ", " ", " ", "*", "*"},
                        {"*", "*", "*", "*", "*", "*", "*", "*"},
                        {"*", "*", "*", "*", "*", "*", "*", "*"},
                };

                assertThat(App.enlargeArrayImage(image)).isEqualTo(doubleImage);
        }


        @Test
        void testImage2() {
                String[][] image = {
                        {"$", "%", "$"},
                        {"%", "$", "%"},
                        {"$", "%", "$"},
                };

                String[][] doubleImage = {
                        {"$", "$", "%", "%", "$", "$"},
                        {"$", "$", "%", "%", "$", "$"},
                        {"%",  "%", "$", "$", "%", "%"},
                        {"%",  "%", "$", "$", "%", "%"},
                        {"$", "$", "%", "%", "$", "$"},
                        {"$", "$", "%", "%", "$", "$"},
                };

                assertThat(App.enlargeArrayImage(image)).isEqualTo(doubleImage);
        }

}
// END
