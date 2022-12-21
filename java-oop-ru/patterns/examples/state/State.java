package exercise.state;

public interface State {
    void go();
    void stop();
    void start();
    void lock();
}
