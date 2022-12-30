package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;

class CircleTest {
    @Test
    void testException() {
        Circle circle = new Circle(new Point(1, 2), -2);
        assertThatThrownBy(() -> {
            circle.getSquare();
        }).isInstanceOf(NegativeRadiusException.class);
    }

    @Test
    void testCircle() throws NegativeRadiusException {
        Circle circle = new Circle(new Point(1, 2), 10);
        int radius = circle.getRadius();
        assertThat(radius).isEqualTo(10);

        double square = circle.getSquare();
        assertThat(square).isCloseTo(314.159, within(0.01));

        Circle circle1 = new Circle(new Point(1, 2), 0);
        double square1 = circle1.getSquare();
        assertThat(square1).isEqualTo(0);
    }
}
