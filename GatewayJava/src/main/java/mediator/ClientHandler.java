package mediator;

import com.google.gson.Gson;
import network.NetworkPackage;
import network.NetworkType;
import service.WebsocketClient;

import java.io.IOException;

public class ClientHandler implements Runnable {

    private WebsocketClient websocketClient;
    private ConnectionHandler handler;
    private Gson gson;

    /**
     * Constructor that initialize instance variables
     *
     * @throws IOException
     */
    public ClientHandler(WebsocketClient websocketClient) throws IOException {
        this.websocketClient = websocketClient;
        this.handler = ConnectionManager.getInstance();
        this.gson = new Gson();
    }

    /**
     * Implementation of run method from Runnable interface
     */
    @Override
    public void run() {
        while (true) {
            try {
                // Reading a gson from server
                String dataFromServer = handler.readFromServer();

                // Converting the gson to NetworkPackage in order to get the type and value
                NetworkPackage incoming = gson.fromJson(dataFromServer, NetworkPackage.class);

                switch (incoming.getType()) {
                    case DATA_VALUE:
                        System.out.println("A ajuns in Client hamdler > " + incoming.getObject());
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
