package sensor;

public class SensorHistory {

    private long sensorId;
    private Sensor sensor;
    private long timestampMillis;
    private double value;

    public SensorHistory(long sensorId, long timestampMillis, double value) {
        this.sensorId = sensorId;
        this.timestampMillis = timestampMillis;
        this.value = value;
    }

    public long getSensorId() {
        return sensorId;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }

    public SensorHistory() {

    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public long getTimestampMillis() {
        return timestampMillis;
    }

    public void setTimestampMillis(long timestampMillis) {
        this.timestampMillis = timestampMillis;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
