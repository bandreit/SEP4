import network.NetworkPackage;
import sensor.SensorHistory;
import service.WebsocketClient;
import com.google.gson.Gson;
import mediator.ConnectionHandler;
import mediator.ConnectionManager;
import network.NetworkType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * The type Main.
 */
public class Main {
    private static final int[] rooms = {1, 2};
    private static final long[] CO2_SENSORS = {1, 4};
    private static final long[] HUM_SENSORS = {2, 5};
    private static final long[] TEMP_SENSORS = {3, 6};
    private static final Random rnd = new Random();


    /**
     * The entry point of application.
     * Sending sensors to the server through WebSockets
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Gson gson = new Gson();
        WebsocketClient websocketClient = new WebsocketClient("wss://iotnet.cibicom.dk/app?token=vnoTuwAAABFpb3RuZXQuY2liaWNvbS5kaxOt1kIOlKdP0z7zj8xIG_I=");

        while (true) {
            try {
                // this is used for downlinks DON'T DELETE, just LEAVE COMENTED

//                String integerAsHexString = Integer.toHexString(69);
//                DownLinkDataMessage downLinkDataMessage = new DownLinkDataMessage(true, integerAsHexString);
//                String downLinkPayload = gson.toJson(downLinkDataMessage, DownLinkDataMessage.class);
//                System.out.println(downLinkPayload);
//                websocketClient.sendDownLink(downLinkPayload);


                ArrayList<SensorHistory> sensorArrayList = new ArrayList<>();

                double decVal = getRandomValue(rnd, 1, 1251, 2);
                int room = getRandomNumber(rooms.length - 1);
                long timestamp = System.currentTimeMillis();

                SensorHistory co2Sensor = new SensorHistory(CO2_SENSORS[room], timestamp, decVal);
                System.out.println(co2Sensor.toString());
                sensorArrayList.add(co2Sensor);

                decVal = getRandomValue(rnd, 1, 1251, 2);
                SensorHistory humSensor = new SensorHistory(HUM_SENSORS[room], timestamp, decVal);
                System.out.println(humSensor.toString());
                sensorArrayList.add(humSensor);

                decVal = getRandomValue(rnd, 1, 1251, 2);
                SensorHistory temperatureSensor = new SensorHistory(TEMP_SENSORS[room], timestamp, decVal);
                System.out.println(temperatureSensor.toString());
                sensorArrayList.add(temperatureSensor);

                ConnectionHandler handler = ConnectionManager.getInstance();
                NetworkPackage networkPackage = new NetworkPackage(NetworkType.SensorList, sensorArrayList);
                String gsonToServer = gson.toJson(networkPackage);
                handler.sendToServer(gsonToServer);
                sensorArrayList.clear();

                Thread.sleep(3000);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Gets random value.
     *
     * @param random        the random
     * @param lowerBound    the lower bound
     * @param upperBound    the upper bound
     * @param decimalPlaces the decimal places
     * @return the random value
     */
    public static double getRandomValue(final Random random,
                                        final int lowerBound,
                                        final int upperBound,
                                        final int decimalPlaces) {

        if (lowerBound < 0 || upperBound <= lowerBound || decimalPlaces < 0) {
            throw new IllegalArgumentException("Put error message here");
        }

        return ((random == null ? new Random() : random).nextDouble() //
                * (upperBound - lowerBound))
                + lowerBound;

    }

    private static int getRandomNumber(int max) {
        return (int) Math.floor(Math.random() * (max + 1));
    }
}
