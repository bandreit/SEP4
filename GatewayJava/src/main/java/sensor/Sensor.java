package sensor;

import java.sql.Timestamp;

public class Sensor {
    private SensorType sensorType;
    private String unitType;
    private double value;
    private long longTimestamp;
    private Timestamp timestamp;


    public Sensor(SensorType sensorType, String unitType, double value, long longTimestamp) {
        this.sensorType = sensorType;
        this.unitType = unitType;
        this.value = value;
        this.longTimestamp = longTimestamp;
        timestamp = new Timestamp(longTimestamp);
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

    public long getLongTimestamp() {
        return longTimestamp;
    }

    public void setLongTimestamp(long longTimestamp) {
        this.longTimestamp = longTimestamp;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "sensorType=" + sensorType +
                ", unitType='" + unitType + '\'' +
                ", value=" + value +
                ", longTimestamp=" + longTimestamp +
                ", timestamp=" + timestamp +
                '}';
    }
}