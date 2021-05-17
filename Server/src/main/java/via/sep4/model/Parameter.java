package via.sep4.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import via.sep4.model.SensorType;

import java.sql.Timestamp;

public class Parameter {
    private SensorType sensorType;
    private String unitType;
    private double value;
    private Timestamp timestamp;

    @JsonCreator
    public Parameter(@JsonProperty("sensorName") SensorType sensorType, @JsonProperty("unitType") String unitType, @JsonProperty("unitType") double value, @JsonProperty("sensorTimeStamp") Timestamp timestamp) {
        this.sensorType = sensorType;
        this.unitType = unitType;
        this.value = value;
        this.timestamp = timestamp;
    }

    public SensorType  getSensorName() {
        return sensorType;
    }

    public void setSensorName(SensorType  sensorType) {
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "sensorName='" + sensorType + '\'' +
                ", unitType='" + unitType + '\'' +
                ", value= " + value +
                ", timestamp= " + timestamp +
                '}';
    }
}