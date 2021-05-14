public class SensorConvertingService {
    private String hexVal;
    private int decVal;

    public SensorConvertingService() {
    }

    public void convert(UpLinkDataMessage upLinkDataMessage) {
        hexVal = upLinkDataMessage.getData().substring(0, 4);
        decVal = Integer.parseInt(hexVal, 16);
        Sensor temperatureSensor = new Sensor(SensorType.TEMPERATURE, "C", ((double) decVal) / 10, upLinkDataMessage.getTs());
        System.out.println(temperatureSensor.toString());

        hexVal = upLinkDataMessage.getData().substring(4, 8);
        decVal = Integer.parseInt(hexVal, 16);
        Sensor humSensor = new Sensor(SensorType.HUMIDITY, "%", ((double) decVal) / 10, upLinkDataMessage.getTs());
        System.out.println(humSensor.toString());

        hexVal = upLinkDataMessage.getData().substring(8, 12);
        decVal = Integer.parseInt(hexVal, 16);
        Sensor co2Sensor = new Sensor(SensorType.CO2, "ppm", decVal, upLinkDataMessage.getTs());
        System.out.println(co2Sensor.toString());
    }
}
