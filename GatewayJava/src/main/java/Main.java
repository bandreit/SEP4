import network.NetworkPackage;
import sensor.Sensor;
import sensor.SensorType;
import service.DownLinkDataMessage;
import service.WebsocketClient;
import com.google.gson.Gson;
import mediator.ConnectionHandler;
import mediator.ConnectionManager;
import network.NetworkType;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Main {
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


                ArrayList<Sensor> sensorArrayList = new ArrayList<>();

                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = dateFormat.parse("23/09/2007");
                long time = date.getTime();

                final Random rnd = new Random();
                double decVal = Double.parseDouble(getRandomValue(rnd, 1, 1251, 2));


                Sensor co2Sensor = new Sensor(SensorType.CO2, "ppm", decVal, time);
                sensorArrayList.add(co2Sensor);

                Sensor humSensor = new Sensor(SensorType.HUMIDITY, "%", ((double) decVal) / 10, time);
                sensorArrayList.add(humSensor);

                Sensor temperatureSensor = new Sensor(SensorType.TEMPERATURE, "C", ((double) decVal) / 10, time);
                sensorArrayList.add(temperatureSensor);

                ConnectionHandler handler = ConnectionManager.getInstance();
                NetworkPackage networkPackage = new NetworkPackage(NetworkType.SensorList, sensorArrayList);
                String gsonToServer = gson.toJson(networkPackage);
                handler.sendToServer(gsonToServer);
                sensorArrayList.clear();


                Thread.sleep(30000);
            } catch (InterruptedException | IOException | ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getRandomValue(final Random random,
                                        final int lowerBound,
                                        final int upperBound,
                                        final int decimalPlaces) {

        if (lowerBound < 0 || upperBound <= lowerBound || decimalPlaces < 0) {
            throw new IllegalArgumentException("Put error message here");
        }

        final double dbl =
                ((random == null ? new Random() : random).nextDouble() //
                        * (upperBound - lowerBound))
                        + lowerBound;
        return String.format("%." + decimalPlaces + "f", dbl);

    }
}
