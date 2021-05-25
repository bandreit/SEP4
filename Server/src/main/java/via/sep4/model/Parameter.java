package via.sep4.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "Parameter")
@Table(name = "parameter")
public class Parameter {
    @Column(updatable = false)
    private SensorType sensorType;
    @Column(updatable = false)
    private String unitType;
    @Column(updatable = false)
    private double value;
    @Column(updatable = false)
    private Timestamp timestamp;
    private double minTemp;
    private double minCo2;
    private double minHum;
    private double maxTemp;
    private double maxCo2;
    private double maxHum;
    private double currentTemp;
    private double currentCo2;
    private double currentHum;

    @Id
    @Column(updatable = false)
    private int id;

    @JsonCreator
    public Parameter(@JsonProperty("sensorName") SensorType sensorType, @JsonProperty("unitType") String unitType, @JsonProperty("value") double value, @JsonProperty("sensorTimeStamp") Timestamp timestamp) {
        this.sensorType = sensorType;
        this.unitType = unitType;
        this.value = value;
        this.timestamp = timestamp;
        this.minTemp = 0;
        this.maxTemp = 0;
        this.minCo2 = 0;
        this.maxCo2 = 0;
        this.minHum = 0;
        this.maxHum = 0;
        this.currentTemp = 0;
        this.currentCo2 = 0;
        this.currentHum = 0;

    }

    public Parameter() {

    }

    public double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(double currentTemp) {
        this.currentTemp = currentTemp;
    }

    public double getCurrentCo2() {
        return currentCo2;
    }

    public void setCurrentCo2(double currentCo2) {
        this.currentCo2 = currentCo2;
    }

    public double getCurrentHum() {
        return currentHum;
    }

    public void setCurrentHum(double currentHum) {
        this.currentHum = currentHum;
    }

    public void setMaxCo2(double maxCo2) {
        this.maxCo2 = maxCo2;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public void setMaxHum(double maxHum) {
        this.maxHum = maxHum;
    }

    public double getMaxCo2() {
        return maxCo2;
    }

    public double getMaxHum() {
        return maxHum;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getMinCo2() {
        return minCo2;
    }

    public double getMinHum() {
        return minHum;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinCo2(double minCo2) {
        this.minCo2 = minCo2;
    }

    public void setMinHum(double minHum) {
        this.minHum = minHum;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
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

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }
}