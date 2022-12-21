package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;
import exercise.connections.Connected;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// BEGIN
public class TcpConnection {

    private String ipAddress;
    private int portNumber;
    private Connection connectionState;
    private List<String> buffer = new ArrayList<>();


    TcpConnection(String ip, int port) {
        this.ipAddress = ip;
        this.portNumber = port;
        this.connectionState = new Disconnected(this);
        }


    public void setState(Connection connectionState) {
        this.connectionState = connectionState;
    }

        /*— возвращает текущее состояние в виде строки*/
    public String getCurrentState() {
        return this.connectionState.getCurrentState();
    }
        /*— устанавливает новое соединение*/
        public void connect() {
            this.connectionState.connect();
        }

        /*— разрывает установленное соединение*/
        public void disconnect() {
            this.connectionState.disconnect();
        }

        /*— добавляет текстовые данные в буфер*/
        public void write(String data) {
            if (Objects.equals(this.connectionState.getCurrentState(), "connected")) {
                this.buffer.add(data);
            } else {
                System.out.println("Error! Can't write while disconnected");
            }
        }
}
// END