package via.sep4.model.SensorHistory;

import com.fasterxml.jackson.annotation.JsonBackReference;
import via.sep4.model.Room.Room;
import via.sep4.model.Sensor.Sensor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sensorhistory")

public class SensorHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sensorid", nullable = false)
    private Sensor sensor;
    @Column(name = " timestamp")
    private Timestamp timestamp;
    @Column(name = "value")
    private double value;

    public SensorHistory(Sensor sensor, Timestamp timestamp, double value) {
        this.sensor = sensor;
        this.timestamp = timestamp;
        this.value = value;
    }

    public SensorHistory() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonBackReference
    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
