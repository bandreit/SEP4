package sensor;

/**
 * The type Sensor history.
 */
public class SensorHistory {

    private long sensorId;
    private Sensor sensor;
    private long timestampMillis;
    private double value;

    /**
     * Instantiates a new Sensor history.
     *
     * @param sensorId        the sensor id
     * @param timestampMillis the timestamp millis
     * @param value           the value
     */
    public SensorHistory(long sensorId, long timestampMillis, double value) {
        this.sensorId = sensorId;
        this.timestampMillis = timestampMillis;
        this.value = value;
    }

    /**
     * Gets sensor id.
     *
     * @return the sensor id
     */
    public long getSensorId() {
        return sensorId;
    }

    /**
     * Sets sensor id.
     *
     * @param sensorId the sensor id
     */
    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * Instantiates a new Sensor history.
     */
    public SensorHistory() {

    }

    /**
     * Gets sensor.
     *
     * @return the sensor
     */
    public Sensor getSensor() {
        return sensor;
    }

    /**
     * Sets sensor.
     *
     * @param sensor the sensor
     */
    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    /**
     * Gets timestamp millis.
     *
     * @return the timestamp millis
     */
    public long getTimestampMillis() {
        return timestampMillis;
    }

    /**
     * Sets timestamp millis.
     *
     * @param timestampMillis the timestamp millis
     */
    public void setTimestampMillis(long timestampMillis) {
        this.timestampMillis = timestampMillis;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(double value) {
        this.value = value;
    }
}
