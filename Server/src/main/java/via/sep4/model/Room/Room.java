package via.sep4.model.Room;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "roomid")
    private int roomid;
    @Column(updatable = false)
    private String roomname;
    //    @OneToMany
//    @JoinTable(joinColumns = @JoinColumn(name = "sensorId"), inverseJoinColumns = @JoinColumn(name = "Id"))
    @Column(name = "sensorid")
    private int sensorid;
    @Column(name = "productid")
    private int productid;

    public Room(String roomname, int productid, int sensorid) {
        this.roomname = roomname;
        this.sensorid = sensorid;
        this.productid = productid;
    }

    public Room() {
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getId() {
        return roomid;
    }

    public void setId(int id) {
        this.roomid = id;
    }

    public String getName() {
        return roomname;
    }

    public void setName(String name) {
        this.roomname = name;
    }

    public int getSensorId() {
        return sensorid;
    }

    public void setSensorId(int sensorId) {
        this.sensorid = sensorId;
    }
}
