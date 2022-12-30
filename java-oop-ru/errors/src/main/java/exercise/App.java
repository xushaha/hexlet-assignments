package exercise;

// BEGIN
public class App {

    public static void printSquare(Circle circle) {
        try {
            double result = Math.ceil(circle.getSquare());
            System.out.println((int) result);
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END
