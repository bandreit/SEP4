package via.sep4.model.Charts;

import via.sep4.model.Sensor.SensorType;

import java.sql.Timestamp;
import java.util.List;

public class Chart {

    private long roomId;
    private long sensorId;
    private SensorType name;
    private List<SensorValue> values;
//    private List<Timestamp> timestamps;

    public Chart() {
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

//    public List<Timestamp> getTimestamps() {
//        return timestamps;
//    }
//
//    public void setTimestamps(List<Timestamp> timestamps) {
//        this.timestamps = timestamps;
//    }

    public List<SensorValue> getValues() {
        return values;
    }

    public void setValues(List<SensorValue> values) {
        this.values = values;
    }

    public long getSensorId() {
        return sensorId;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }

    public SensorType getName() {
        return name;
    }

    public void setName(SensorType name) {
        this.name = name;
    }
}
