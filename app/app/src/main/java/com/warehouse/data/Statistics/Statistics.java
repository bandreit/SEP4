package com.warehouse.data.Statistics;

import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Statistics {
    @PrimaryKey
    @NotNull
    private String roomId;
    private String sensorId;
    private String name;
    private List<StatisticsValue> values;

    public Statistics(String roomId, String sensorId, String name, List<StatisticsValue> values) {
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

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String stringId) {
        this.sensorId = stringId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StatisticsValue> getValues() {
        return values;
    }

    public void setValues(List<StatisticsValue> values) {
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
