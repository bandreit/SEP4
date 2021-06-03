package sensor;

import java.sql.Timestamp;

/**
 * The type Sensor.
 */
public class Sensor {
    private SensorType sensorType;
    private String unitType;
    private double value;
    private long longTimestamp;
    private Timestamp timestamp;


    /**
     * Instantiates a new Sensor.
     *
     * @param sensorType    the sensor type
     * @param unitType      the unit type
     * @param value         the value
     * @param longTimestamp the long timestamp
     */
    public Sensor(SensorType sensorType, String unitType, double value, long longTimestamp) {
        this.sensorType = sensorType;
        this.unitType = unitType;
        this.value = value;
        this.longTimestamp = longTimestamp;
        timestamp = new Timestamp(longTimestamp);
    }

    /**
     * Gets sensor type.
     *
     * @return the sensor type
     */
    public SensorType getSensorType() {
        return sensorType;
    }

    /**
     * Sets sensor type.
     *
     * @param sensorType the sensor type
     */
    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }

    /**
     * Gets unit type.
     *
     * @return the unit type
     */
    public String getUnitType() {
        return unitType;
    }

    /**
     * Sets unit type.
     *
     * @param unitType the unit type
     */
    public void setUnitType(String unitType) {
        this.unitType = unitType;
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
     * Gets long timestamp.
     *
     * @return the long timestamp
     */
    public long getLongTimestamp() {
        return longTimestamp;
    }

    /**
     * Sets long timestamp.
     *
     * @param longTimestamp the long timestamp
     */
    public void setLongTimestamp(long longTimestamp) {
        this.longTimestamp = longTimestamp;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
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