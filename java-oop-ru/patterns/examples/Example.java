package exercise;

import exercise.state.Car;
import exercise.state.State;

public class Example {
    public static void main(String[] args) {
//        Car car = Car.newBuilder()
//                .setDoorsAmount(5)
//                .setName("Renault")
//                .setColor(Color.BLACK)
//                .setEnginePower(129.9)
//                .build();
//
//        System.out.println(car);

        Car car2 = new Car();
        car2.getState().go();
//
        // start car
        car2.getState().start();
        car2.getState().go();
//
        car2.getState().lock();

        State state = car2.getState();
        if (state != null) {
            state.stop();
        }

        car2.getState().lock();
    }
}
