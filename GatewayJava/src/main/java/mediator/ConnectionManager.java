package mediator;

import java.io.*;
import java.net.Socket;

public class ConnectionManager implements ConnectionHandler {
    /**
     * The constant HOST.
     */
    public static final String HOST = "localhost";
    /**
     * The constant PORT.
     */
    public static final int PORT = 9876;
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private static ConnectionManager instance;

    private static Object lock = new Object();

    private ConnectionManager() throws IOException {
        connect();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     * @throws IOException the io exception
     */
    public static ConnectionManager getInstance() throws IOException {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ConnectionManager();
                }
            }
        }
        return instance;
    }

    @Override
    public void connect() throws IOException {
        this.socket = new Socket(HOST, PORT);
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void disconnect() throws IOException {
        socket.close();
    }

    /**
     * Sends bytes via Socket connection
     *
     * @param message the message
     * @throws IOException the io exception
     */
    @Override
    public void sendToServer(String message) throws IOException {
        byte[] toSendBytes = message.getBytes();
        int toSendLen = toSendBytes.length;
        byte[] toSendLenBytes = new byte[4];
        toSendLenBytes[0] = (byte) (toSendLen & 0xff);
        toSendLenBytes[1] = (byte) ((toSendLen >> 8) & 0xff);
        toSendLenBytes[2] = (byte) ((toSendLen >> 16) & 0xff);
        toSendLenBytes[3] = (byte) ((toSendLen >> 24) & 0xff);
        outputStream.write(toSendLenBytes);
        outputStream.write(toSendBytes);
    }

    /**
     * Receives bytes via Socket connection
     *
     * @throws IOException the io exception
     */
    @Override
    public String readFromServer() throws IOException {
        byte[] lenBytes = new byte[4];
        inputStream.readFully(lenBytes, 0, 4);
        int len = (((lenBytes[3] & 0xff) << 24) | ((lenBytes[2] & 0xff) << 16) |
                ((lenBytes[1] & 0xff) << 8) | (lenBytes[0] & 0xff));
        byte[] receivedBytes = new byte[len];
        inputStream.readFully(receivedBytes, 0, len);

        return new String(receivedBytes, 0, len);
    }
}
