package exercise;

// BEGIN
public class Circle {

    Point center;
    int radius;

    Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

        //Если радиус круга меньше нуля, метод должен выбросить исключение NegativeRadiusException
    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw NegativeRadiusException.INVALID_RADIUS;
        } else {
            return Math.PI * radius * radius;
        }
    }

}
// END
