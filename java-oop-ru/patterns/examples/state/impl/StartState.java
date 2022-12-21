package exercise.state.impl;

import exercise.state.Car;
import exercise.state.State;

@SuppressWarnings("HiddenField")
public class StartState implements State {
    private Car car;

    public StartState(Car car) {
        this.car = car;
    }

    @Override
    public void go() {
        Car car = this.car;
        car.setState(new DriveState(car));
        System.out.println("Okey, I can do it.");
    }

    @Override
    public void stop() {
        System.out.println("Okey, I can be stopped.");
    }

    @Override
    public void start() {
        System.out.println("I have been started.");
    }

    @Override
    public void lock() {
        Car c = this.car;
        c.setState(new LockedState(c));
        System.out.println("Car has been locked.");
    }


}
