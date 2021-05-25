package via.sep4.mediator;


import com.google.gson.Gson;
import via.sep4.model.Sensor;
import via.sep4.network.NetworkPackage;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private Gson gson;

    /**
     * Instantiates a new Client handler.
     *
     * @param socket the socket
     * @throws IOException the io exception
     */
    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        inputStream = this.socket.getInputStream();
        // ??? los like we don't need to initiate a socket
        outputStream = socket.getOutputStream();
        this.gson = new Gson();
    }

    /**
     * Reeds data from Business logic tier and sends back relevant information
     * <p>
     * THE MAIN METHOD OF ALL DATA TIER
     */
    @Override
    public void run() {
        while (true) {
            try {
                //reading message from the client
                String message = readData();

                //incoming data
                System.out.println("Client > " + message);
                NetworkPackage incoming = gson.fromJson(message, NetworkPackage.class);

                switch (incoming.getType()) {
                    case SensorList:
                        ArrayList<Sensor> incomingSensorData = (ArrayList<Sensor>) incoming.getObject();
                        // put it inside the database DatabasePersitance or smth
                        System.out.println("Privet in server : " + incomingSensorData);
                        break;
                    default:
                        sendData("ERROR");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Client disconnected");
                e.printStackTrace();
                break;
            }
        }
    }

    /**
     * Responsible to send bytes via the Socket connection
     *
     * @param response string
     * @throws IOException the io exception
     */
    private void sendData(String response) throws IOException {
        byte[] toSendBytes = response.getBytes();
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
     * Responsible to get bytes via the Socket connection
     * receiving the message from client
     *
     * @throws IOException the io exception
     */
    public String readData() throws IOException {
        byte[] lenBytes = new byte[4];
        inputStream.read(lenBytes, 0, 4);
        int len = (((lenBytes[3] & 0xff) << 24) | ((lenBytes[2] & 0xff) << 16) |
                ((lenBytes[1] & 0xff) << 8) | (lenBytes[0] & 0xff));
        byte[] receivedBytes = new byte[len];
        inputStream.read(receivedBytes, 0, len);

        return new String(receivedBytes, 0, len);
    }
}