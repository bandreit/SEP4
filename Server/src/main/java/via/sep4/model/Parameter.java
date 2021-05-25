package via.sep4.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "Parameter")
@Table(name = "dbo.Parameter")
public class Parameter {
    @Column(updatable = false)
    private SensorType sensorType;
    @Column(updatable = false)
    private String unitType;
    @Column(updatable = false)
    private double value;
    @Column(updatable = false)
    private Timestamp timestamp;
    @Column(updatable = true)
    private double minTemp;
    @Column(updatable = true)
    private double minCo2;
    @Column(updatable = true)
    private double minHum;
    @Column(updatable = true)
    private double maxTemp;
    @Column(updatable = true)
    private double maxCo2;
    @Column(updatable = true)
    private double maxHum;
    @Column(updatable = true)
    private double currentTemp;
    @Column(updatable = true)
    private double currentCo2;
    @Column(updatable = true)
    private double currentHum;

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "employee_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(updatable = false)
    private long id;
    @JsonCreator
    public Parameter(@JsonProperty("sensorName") SensorType sensorType, @JsonProperty("unitType") String unitType, @JsonProperty("unitType") double value, @JsonProperty("sensorTimeStamp") Timestamp timestamp) {
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

    public void setId(long id) {
        this.id = id;
    }

    @Id
    public long getId() {
        return id;
    }
}