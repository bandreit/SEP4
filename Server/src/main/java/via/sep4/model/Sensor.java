package via.sep4.model;

public class Sensor {
    private SensorType sensorType;
    private String unitType;
    private double value;
    private long timestamp;

    public Sensor(SensorType sensorType, String unitType, double value, long timestamp) {
        this.sensorType = sensorType;
        this.unitType = unitType;
        this.value = value;
        this.timestamp = timestamp;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "sensor.Sensor{" +
                "sensorType=" + sensorType +
                ", unitType='" + unitType + '\'' +
                ", value=" + value +
                ", timestamp=" + timestamp +
                '}';
    }
}