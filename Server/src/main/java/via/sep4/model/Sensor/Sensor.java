package via.sep4.model.Sensor;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import via.sep4.model.Room.Room;
import via.sep4.model.SensorHistory.SensorHistory;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

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
    @Column
    private double currentValue;
    @Column(name = "minvalue")
    private double minValue;
    @Column(name = "maxvalue")
    private double maxValue;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roomid", nullable = false)
    private Room room;
    @OneToMany(mappedBy = "sensor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<SensorHistory> history;

    public Sensor(SensorType sensorType, String unitType, Room room) {
        this.sensorType = sensorType;
        this.unitType = unitType;
        this.maxValue = 0;
        this.minValue = 0;
        this.currentValue = 0;
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

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }


    public Long getSensorID() {
        return sensorID;
    }

    public void setSensorID(Long sensorID) {
        this.sensorID = sensorID;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    @JsonManagedReference
    public Set<SensorHistory> getHistory() {
        return history;
    }

    public void setHistory(Set<SensorHistory> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "name ='" + sensorType + '\'' +
                ", unitType='" + unitType + '\'' +
                ", currentValue= " + currentValue +
                '}';
    }
}