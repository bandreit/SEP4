package com.warehouse.data.Room;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Room {
    @SerializedName("roomid")
    private String id;
    @SerializedName("roomname")
    private String name;
    private List<Sensor> sensors;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

}
