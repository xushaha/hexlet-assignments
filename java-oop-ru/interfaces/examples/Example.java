package exercise;

import java.util.List;

public class Example {
    public static void main(String[] args) {
        // !!! No ability to do: Car c = new Car();
        System.out.println("Object type: " + Car.TYPE);
        Car kia = new Kia();
        Car bmw = new Bmw();

        kia.go();
        bmw.go();

        kia.stop();
        bmw.stop();

        System.out.println("KIA: " + kia.getMaxSpeed());
        System.out.println("BMW: " + bmw.getMaxSpeed());

        // разогнать все машины
        List<Car> carList = List.of(kia, bmw);
        for (Car car : carList) {
            car.go();
        }

        // остановить все машины
        for (Car car : carList) {
            car.stop();
        }

        // строчное представление машин
        for (Car car : carList) {
            car.printCar();
        }
    }
}
