package via.sep4.model.SensorHistory;

import via.sep4.model.Sensor.Sensor;

public class SensorHistoryO {

    private long sensorId;
    private Sensor sensor;
    private long timestamp;
    private double value;

    public SensorHistoryO(long sensorId, long timestamp, double value) {
        this.sensorId = sensorId;
        this.timestamp = timestamp;
        this.value = value;
    }

    public long getSensorId() {
        return sensorId;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }

    public SensorHistoryO() {

    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
