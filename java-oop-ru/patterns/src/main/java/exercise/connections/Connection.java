package exercise.connections;

public interface Connection {
    // BEGIN
    void connect();
    void disconnect();
    String getCurrentState();
    // END
}
