import service.DownLinkDataMessage;
import service.WebsocketClient;
import com.google.gson.Gson;
import mediator.ConnectionHandler;
import mediator.ConnectionManager;
import network.NetworkType;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Gson gson = new Gson();
        WebsocketClient websocketClient = new WebsocketClient("wss://iotnet.cibicom.dk/app?token=vnoTuwAAABFpb3RuZXQuY2liaWNvbS5kaxOt1kIOlKdP0z7zj8xIG_I=");

        while (true) {
            try {
                String integerAsHexString = Integer.toHexString(69);
                DownLinkDataMessage downLinkDataMessage = new DownLinkDataMessage(true, integerAsHexString);
                String downLinkPayload = gson.toJson(downLinkDataMessage, DownLinkDataMessage.class);
                System.out.println(downLinkPayload);
                websocketClient.sendDownLink(downLinkPayload);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
