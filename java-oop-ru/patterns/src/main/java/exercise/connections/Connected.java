package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {

        private TcpConnection tcpConnection;

        public Connected(TcpConnection tcpConnection) {
                this.tcpConnection = tcpConnection;
        }

        @Override
        public void connect() {
                System.out.println("Error! Already connected");
        }

        @Override
        public void disconnect() {
                this.tcpConnection.setState(new Disconnected(this.tcpConnection));
                System.out.println("Disconnected");
        }

        @Override
        public String getCurrentState() {
                return "connected";
        }
}
// END