package via.sep4.model.Charts;

import via.sep4.model.Sensor.Sensor;

import java.util.Set;

/**
 * The type Data.
 */
public class DataRooms{
    private long roomid;
    private String roomname;
    private Set<Sensor> sensors;


    /**
     * Instantiates a new Data.
     */
    public DataRooms() {
    }

    /**
     * Gets roomid.
     *
     * @return the roomid
     */
    public long getRoomid() {
        return roomid;
    }

    /**
     * Sets roomid.
     *
     * @param roomid the roomid
     */
    public void setRoomid(long roomid) {
        this.roomid = roomid;
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
     * Sets roomname.
     *
     * @param roomname the roomname
     */
    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    /**
     * Gets list of sensors.
     *
     * @return the list of sensors
     */
    public Set<Sensor> getListOfSensors() {
        return sensors;
    }

    /**
     * Sets list of sensors.
     *
     * @param listOfSensors the list of sensors
     */
    public void setListOfSensors(Set<Sensor> listOfSensors) {
        this.sensors = listOfSensors;
    }
}
