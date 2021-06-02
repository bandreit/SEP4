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
    private static final int[] rooms = {1, 2};
    private static final long[] CO2_SENSORS = {1, 4};
    private static final long[] HUM_SENSORS = {2, 5};
    private static final long[] TEMP_SENSORS = {3, 6};

    public SensorConvertingService() {
    }

    public void convertAndSend(UpLinkDataMessage upLinkDataMessage) {
        ArrayList<SensorHistory> sensorArrayList = new ArrayList<>();
        long timestamp = upLinkDataMessage.getTs();
        int room = getRandomNumber(rooms.length - 1);

        hexVal = upLinkDataMessage.getData().substring(0, 4);
        decVal = Integer.parseInt(hexVal, 16);
        SensorHistory co2Sensor = new SensorHistory(CO2_SENSORS[room], timestamp, decVal);
        System.out.println(co2Sensor.toString());
        sensorArrayList.add(co2Sensor);

        hexVal = upLinkDataMessage.getData().substring(4, 8);
        decVal = Integer.parseInt(hexVal, 16);
        SensorHistory humSensor = new SensorHistory(HUM_SENSORS[room], timestamp, decVal);
        System.out.println(humSensor.toString());
        sensorArrayList.add(humSensor);

        hexVal = upLinkDataMessage.getData().substring(8, 12);
        decVal = Integer.parseInt(hexVal, 16);
        SensorHistory temperatureSensor = new SensorHistory(TEMP_SENSORS[room], timestamp, decVal);
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

    private static int getRandomNumber(int max) {
        return (int) Math.floor(Math.random() * (max + 1));
    }
}
