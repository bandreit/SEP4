package mediator;

import com.google.gson.Gson;
import network.NetworkPackage;
import service.DownLinkDataMessage;
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
                    case Ventilation:
                        Integer incomingSensorData = gson.fromJson(incoming.getObject().toString(), Integer.class);
                        String integerAsHexString = Integer.toHexString(incomingSensorData);
                        DownLinkDataMessage downLinkDataMessage = new DownLinkDataMessage(true, integerAsHexString);
                        String downLinkPayload = gson.toJson(downLinkDataMessage, DownLinkDataMessage.class);
                        System.out.println(downLinkPayload);
                        websocketClient.sendDownLink(downLinkPayload);
                        break;
                }
            } catch (IOException e) {
                System.out.println("Couldn't process request");
            }
        }
    }
}
