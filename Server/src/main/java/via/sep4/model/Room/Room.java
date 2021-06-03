package via.sep4.model.Room;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import via.sep4.model.Sensor.Sensor;
import javax.persistence.*;
import java.util.Set;

/**
 * The type Room.
 */
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomid")
    private Long roomid;

    @Column(updatable = false, unique = true)
    private String roomname;
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sensor> sensors;


    /**
     * Instantiates a new Room.
     *
     * @param roomname the roomname
     */
    public Room(String roomname) {
        this.roomname = roomname;
    }

    /**
     * Instantiates a new Room.
     */
    public Room() {
    }

    /**
     * Gets roomid.
     *
     * @return the roomid
     */
    public Long getRoomid() {
        return roomid;
    }

    /**
     * Sets roomid.
     *
     * @param roomid the roomid
     */
    public void setRoomid(Long roomid) {
        this.roomid = roomid;
    }

    /**
     * Gets sensors.
     *
     * @return the sensors
     */
    @JsonManagedReference
    public Set<Sensor> getSensors() {
        return sensors;
    }

    /**
     * Sets roomname.
     *
     * @param roomname the roomname
     */
    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    /**
     * Gets roomname.
     *
     * @return the roomname
     */
    public String getRoomname() {
        return roomname;
    }

    /**
     * Sets sensors.
     *
     * @param sensors the sensors
     */
    public void setSensors(Set<Sensor> sensors) {
        this.sensors = sensors;
    }
}
