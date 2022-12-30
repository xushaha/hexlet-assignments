package exercise;

// BEGIN
public class App {

    public static void printSquare(Circle circle) throws NegativeRadiusException {
        double result = Math.ceil(circle.getSquare());
        System.out.println((int) result);
        System.out.println("Вычисление окончено");
    }
}
// END

