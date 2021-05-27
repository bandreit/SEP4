package via.sep4.model.Sensor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Sensor")
public class Sensor {


    @Column(updatable = false, name = "sensortype")
    private SensorType sensorType;
    @Column(updatable = false, name = "unittype")
    private String unitType;
    @Column(updatable = false, name = "sensorvalue")
    private double sensorValue;
    @Column(updatable = false, name = "sensortimestamp")
    private Timestamp sensorTimeStamp;
    @Column(name = "minvalue")
    private int minValue;
    @Column(name = "maxvalue")
    private int maxValue;
    @Column(name = "currentvalue")
    private int currentValue;
    @Id
    @Column(updatable = false, name = "sensorid")
    private int sensorID;


    @JsonCreator
    public Sensor(@JsonProperty("sensorType") SensorType sensorType, @JsonProperty("unitType") String unitType, @JsonProperty("sensorValue") double value, @JsonProperty("sensorTimeStamp") Timestamp timestamp) {
        this.sensorType = sensorType;
        this.unitType = unitType;
        this.sensorValue = value;
        this.sensorTimeStamp = timestamp;
        this.currentValue = 0;
        this.maxValue = 0;
        this.minValue = 0;
    }

    public Sensor() {
    }

    public int getMin() {
        return minValue;
    }

    public void setMin(int minValue) {
        this.minValue = minValue;
    }

    public int getMax() {
        return maxValue;
    }

    public void setMax(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public SensorType getSensorName() {
        return sensorType;
    }

    public void setSensorName(SensorType sensorType) {
        this.sensorType = sensorType;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public double getValue() {
        return sensorValue;
    }

    public void setValue(double value) {
        this.sensorValue = value;
    }

    public Timestamp getTimestamp() {
        return sensorTimeStamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.sensorTimeStamp = timestamp;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "name ='" + sensorType + '\'' +
                ", unitType='" + unitType + '\'' +
                ", value= " + sensorValue +
                ", timestamp= " + sensorTimeStamp +
                '}';
    }

    public void setId(int id) {
        this.sensorID = id;
    }

    public int getId() {
        return sensorID;
    }
}