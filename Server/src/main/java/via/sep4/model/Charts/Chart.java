package via.sep4.model.Charts;

import via.sep4.model.Sensor.SensorType;
import java.util.List;

/**
 * The type Chart.
 */
public class Chart {

    private long roomId;
    private long sensorId;
    private SensorType name;
    private List<SensorValue> values;

    /**
     * Instantiates a new Chart.
     */
    public Chart() {
    }

    /**
     * Gets room id.
     *
     * @return the room id
     */
    public long getRoomId() {
        return roomId;
    }

    /**
     * Sets room id.
     *
     * @param roomId the room id
     */
    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    /**
     * Gets values.
     *
     * @return the values
     */
    public List<SensorValue> getValues() {
        return values;
    }

    /**
     * Sets values.
     *
     * @param values the values
     */
    public void setValues(List<SensorValue> values) {
        this.values = values;
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
     * Gets name.
     *
     * @return the name
     */
    public SensorType getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(SensorType name) {
        this.name = name;
    }
}
