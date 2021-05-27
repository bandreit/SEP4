package via.sep4.model.Sensor;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import via.sep4.model.Room.Room;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sensor")
public class Sensor {
    @Id
    @Column(updatable = false, name = "sensorid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sensorID;


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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roomid", nullable = false)
    private Room room;


    @JsonCreator
    public Sensor(SensorType sensorType, String unitType, double value, Timestamp timestamp, Room room) {
        this.sensorType = sensorType;
        this.unitType = unitType;
        this.sensorValue = value;
        this.sensorTimeStamp = timestamp;
        this.currentValue = 0;
        this.maxValue = 0;
        this.minValue = 0;
        this.room = room;
    }

    public Sensor() {
    }

    @JsonBackReference
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public void setId(Long id) {
        this.sensorID = id;
    }

    public Long getId() {
        return sensorID;
    }
}