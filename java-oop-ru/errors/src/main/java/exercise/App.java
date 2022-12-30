package exercise;

// BEGIN
public class App {
/*    Реализуйте класс App и публичный статический метод printSquare(),
который принимает в качестве аргумента круг Circle и печатает на экран его площадь,
округленную до целого числа. Если в процессе вычисления площади возникло исключение,
метод должен вывести на экран фразу "Не удалось посчитать площадь". В конце на экран должна
выводиться фраза "Вычисление окончено".

      Point point = new Point(5, 7);
      Circle circle = new Circle(point, 4);
      App.printSquare(circle);
      // => "50"
      // => "Вычисление окончено"

      Circle circle1 = new Circle(point, -2);
      App.printSquare(circle1);
// => "Не удалось посчитать площадь"
// => "Вычисление окончено" */




public static void printSquare(Circle circle) throws NegativeRadiusException {
     System.out.println(circle.getSquare());
     System.out.println("Вычисление окончено");
     }
}
// END

