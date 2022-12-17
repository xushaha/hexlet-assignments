package exercise;

public interface Car {
    String TYPE = "car";
    void go();
    void stop();
    String getName();
    int getMaxSpeed();

    default void printCar() {
        System.out.println(getName() + " is a " + TYPE + ". It has ability to go with max speed of " + getMaxSpeed());
    }
}
