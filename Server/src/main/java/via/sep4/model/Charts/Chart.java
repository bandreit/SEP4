package via.sep4.model.Charts;

import via.sep4.model.Sensor.SensorType;

import java.util.List;

public class Chart {

    private long sensorId;
    private SensorType sensorType;
    private List<Double> average;


    public Chart() {
    }

    public List<Double> getAverage() {
        return average;
    }

    public void setAverage(List<Double> average) {
        this.average = average;
    }

    public long getSensorId() {
        return sensorId;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }
}