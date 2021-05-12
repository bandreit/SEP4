import com.google.gson.Gson;
import mediator.ConnectionHandler;
import mediator.ConnectionManager;
import network.NetworkType;
import network.SensorData;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

//        WebsocketClient websocketClient = new WebsocketClient("wss://iotnet.cibicom.dk/app?token=vnoTuwAAABFpb3RuZXQuY2liaWNvbS5kaxOt1kIOlKdP0z7zj8xIG_I=");

        Gson gson = new Gson();

        try {
            ConnectionHandler handler = ConnectionManager.getInstance();

            String privet = "Privet ";
            SensorData data = new SensorData(NetworkType.TEST, privet);
            String gsonToServer = gson.toJson(data);
            handler.sendToServer(gsonToServer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {

        }
    }
}
