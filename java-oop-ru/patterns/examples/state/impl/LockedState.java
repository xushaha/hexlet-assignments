package exercise.state.impl;

import exercise.state.Car;
import exercise.state.State;

public class LockedState implements State {
    private Car car;

    public LockedState(Car car) {
        this.car = car;
    }

    @Override
    public void go() {
        System.out.println("I have been locked. I can't go before you do not start me.");
    }

    @Override
    public void stop() {
        System.out.println("I have been locked. It means that I stopped.");
    }

    @Override
    public void start() {
        Car c = this.car;
        c.setState(new StartState(c));
        System.out.println("Car has been started.");
    }

    @Override
    public void lock() {
        System.out.println("Car has been locked.");
    }
}
