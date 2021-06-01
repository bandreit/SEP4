package via.sep4.mediator;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientConnector implements Runnable {

    /**
     * The Port.
     */
    final int PORT = 9876;
    private ServerSocket welcomeSocket;

    /**
     * Instantiates a new Client connector
     * Connecting to database
     *
     * @throws IOException the io exception
     */
    public ClientConnector() throws IOException {
        this.welcomeSocket = new ServerSocket(PORT);
    }

    @Override
    public void run() {
        System.out.println("Waiting for a client...");
        while (true) {
            try {
                Socket socket = welcomeSocket.accept();
                System.out.println("Client connected");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread t = new Thread(clientHandler);
                t.setDaemon(true);
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
