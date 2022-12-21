package exercise.state;

import exercise.state.impl.LockedState;

public class Car {
    private State state;

    public Car() {
        this.state = new LockedState(this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
