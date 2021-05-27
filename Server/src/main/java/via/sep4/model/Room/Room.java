package via.sep4.model.Room;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import via.sep4.model.Sensor.Sensor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
//    private Set<Products> products;


    public Room(String roomname) {
        this.roomname = roomname;
    }

    public Room() {
    }

    public Long getId() {
        return roomid;
    }

    public void setId(Long id) {
        this.roomid = id;
    }

    public String getName() {
        return roomname;
    }

    public void setName(String name) {
        this.roomname = name;
    }

    public Long getRoomid() {
        return roomid;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
    }

    @JsonManagedReference
    public Set<Sensor> getSensors() {
        return sensors;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setSensors(Set<Sensor> sensors) {
        this.sensors = sensors;
    }
}
