package exercise.state.impl;

import exercise.state.Car;
import exercise.state.State;

public class DriveState implements State {
    private Car car;

    public DriveState(Car car) {
        this.car = car;
    }

    @Override
    public void go() {
        System.out.println("I have gone yet.");
    }

    @Override
    public void stop() {
        System.out.println("Okey, I will stop");
        this.car.setState(new StartState(this.car));
    }

    @Override
    public void start() {
        System.out.println("I have been started.");
    }

    @Override
    public void lock() {
        System.out.println("I can't be locked.");
    }
}
