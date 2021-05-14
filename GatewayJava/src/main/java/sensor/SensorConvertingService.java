package sensor;

import com.google.gson.Gson;
import mediator.ConnectionHandler;
import mediator.ConnectionManager;
import network.NetworkPackage;
import network.NetworkType;
import service.UpLinkDataMessage;

import java.io.IOException;
import java.util.ArrayList;

public class SensorConvertingService {
    private String hexVal;
    private int decVal;

    public SensorConvertingService() {
    }

    public void convertAndSend(UpLinkDataMessage upLinkDataMessage) {
        ArrayList<Sensor> sensorArrayList = new ArrayList<>();

        hexVal = upLinkDataMessage.getData().substring(0, 4);
        decVal = Integer.parseInt(hexVal, 16);
        Sensor co2Sensor = new Sensor(SensorType.CO2, "ppm", decVal, upLinkDataMessage.getTs());
        System.out.println(co2Sensor.toString());
        sensorArrayList.add(co2Sensor);

        hexVal = upLinkDataMessage.getData().substring(4, 8);
        decVal = Integer.parseInt(hexVal, 16);
        Sensor humSensor = new Sensor(SensorType.HUMIDITY, "%", ((double) decVal) / 10, upLinkDataMessage.getTs());
        System.out.println(humSensor.toString());
        sensorArrayList.add(humSensor);


        hexVal = upLinkDataMessage.getData().substring(8, 12);
        decVal = Integer.parseInt(hexVal, 16);
        Sensor temperatureSensor = new Sensor(SensorType.TEMPERATURE, "C", ((double) decVal) / 10, upLinkDataMessage.getTs());
        System.out.println(temperatureSensor.toString());
        sensorArrayList.add(temperatureSensor);


        Gson gson = new Gson();

        try {
            ConnectionHandler handler = ConnectionManager.getInstance();
            NetworkPackage networkPackage = new NetworkPackage(NetworkType.SensorList, sensorArrayList);
            String gsonToServer = gson.toJson(networkPackage);
            handler.sendToServer(gsonToServer);
            sensorArrayList.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
