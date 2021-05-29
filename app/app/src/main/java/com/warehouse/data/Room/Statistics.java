package com.warehouse.data.Room;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Statistics {
    private String roomId;
    private String sensorId;
    private String name;
    private ArrayList<Integer> values;

    public Statistics(String roomId, String sensorId, String name, ArrayList<Integer> values) {
        this.roomId = roomId;
        this.sensorId = sensorId;
        this.name = name;
        this.values = values;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getStringId() {
        return sensorId;
    }

    public void setStringId(String stringId) {
        this.sensorId = stringId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getValues() {
        return values;
    }

    public void setValues(ArrayList<Integer> values) {
        this.values = values;
    }

    @NotNull
    @Override
    public String toString() {
        return "Statistics{" +
                "roomId=" + roomId +
                ", sensorId=" + sensorId +
                ", name='" + name + '\'' +
                ", values=" + values +
                '}';
    }
}
