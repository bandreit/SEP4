package via.sep4.model.SensorHistory;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import via.sep4.model.Sensor.Sensor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The type Sensor history.
 */
@Entity
@Table(name = "sensorhistory")

public class SensorHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sensorid", nullable = false)
    private Sensor sensor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private long sensorId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private long timestampMillis;
    @Column(name = "timestamp")
    private Timestamp timestamp;
    @Column(name = "value")
    private double value;

    /**
     * Instantiates a new Sensor history.
     *
     * @param sensor    the sensor
     * @param timestamp the timestamp
     * @param value     the value
     */
    public SensorHistory(Sensor sensor, Timestamp timestamp, double value) {
        this.sensor = sensor;
        this.timestamp = timestamp;
        this.value = value;
    }

    /**
     * Instantiates a new Sensor history.
     */
    public SensorHistory() {

    }

    /**
     * Gets historyid.
     *
     * @return the historyid
     */
    public Long getHistoryid() {
        return historyid;
    }

    /**
     * Sets historyid.
     *
     * @param id the id
     */
    public void setHistoryid(Long id) {
        this.historyid = id;
    }

    /**
     * Gets sensor.
     *
     * @return the sensor
     */
    @JsonBackReference
    public Sensor getSensor() {
        return sensor;
    }

    /**
     * Sets sensor.
     *
     * @param sensor the sensor
     */
    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    /**
     * Gets sensor id.
     *
     * @return the sensor id
     */
    public long getSensorId() {
        return sensorId;
    }

    /**
     * Sets sensor id.
     *
     * @param sensorId the sensor id
     */
    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * Gets timestamp millis.
     *
     * @return the timestamp millis
     */
    public long getTimestampMillis() {
        return timestampMillis;
    }

    /**
     * Sets timestamp millis.
     *
     * @param timestampMillis the timestamp millis
     */
    public void setTimestampMillis(long timestampMillis) {
        this.timestampMillis = timestampMillis;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(double value) {
        this.value = value;
    }
}
