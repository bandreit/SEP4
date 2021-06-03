package via.sep4.model.Charts;

/**
 * The type Sensor value.
 */
public class SensorValue {
    /**
     * The Value.
     */
    double value;
    /**
     * The Timestamp.
     */
    long timestamp;

    /**
     * Instantiates a new Sensor value.
     *
     * @param value     the value
     * @param timestamp the timestamp
     */
    public SensorValue(double value, long timestamp) {
        this.value = value;
        this.timestamp = timestamp;
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

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
