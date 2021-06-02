package via.sep4.model.Sensor;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import via.sep4.model.Room.Room;
import via.sep4.model.SensorHistory.SensorHistory;

import javax.persistence.*;
import java.util.Set;

/**
 * The type Sensor.
 */
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
    private double currentvalue;
    @Column(name = "minvalue")
    private double minValue;
    @Column(name = "maxvalue")
    private double maxValue;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roomid", nullable = false)
    private Room room;
    @OneToMany(mappedBy = "sensor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<SensorHistory> history;

    /**
     * Instantiates a new Sensor.
     *
     * @param sensorType the sensor type
     * @param unitType   the unit type
     * @param room       the room
     */
    public Sensor(SensorType sensorType, String unitType, Room room) {
        this.sensorType = sensorType;
        this.unitType = unitType;
        this.maxValue = 0;
        this.minValue = 0;
        this.currentvalue = 0;
        this.room = room;
    }

    /**
     * Instantiates a new Sensor.
     */
    public Sensor() {
    }

    /**
     * Gets room.
     *
     * @return the room
     */
    @JsonBackReference
    public Room getRoom() {
        return room;
    }

    /**
     * Sets room.
     *
     * @param room the room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Gets currentvalue.
     *
     * @return the currentvalue
     */
    public double getCurrentvalue() {
        return currentvalue;
    }

    /**
     * Sets currentvalue.
     *
     * @param currentValue the current value
     */
    public void setCurrentvalue(double currentValue) {
        this.currentvalue = currentValue;
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
     * Gets sensor id.
     *
     * @return the sensor id
     */
    public Long getSensorID() {
        return sensorID;
    }

    /**
     * Sets sensor id.
     *
     * @param sensorID the sensor id
     */
    public void setSensorID(Long sensorID) {
        this.sensorID = sensorID;
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
     * Gets min value.
     *
     * @return the min value
     */
    public double getMinValue() {
        return minValue;
    }

    /**
     * Sets min value.
     *
     * @param minValue the min value
     */
    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    /**
     * Gets max value.
     *
     * @return the max value
     */
    public double getMaxValue() {
        return maxValue;
    }

    /**
     * Sets max value.
     *
     * @param maxValue the max value
     */
    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * Gets history.
     *
     * @return the history
     */
    @JsonManagedReference
    public Set<SensorHistory> getHistory() {
        return history;
    }

    /**
     * Sets history.
     *
     * @param history the history
     */
    public void setHistory(Set<SensorHistory> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "name ='" + sensorType + '\'' +
                ", unitType='" + unitType + '\'' +
                ", currentValue= " + currentvalue +
                '}';
    }
}