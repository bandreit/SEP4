package com.warehouse.data.Statistics;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.warehouse.adapters.SensorsDataConverter;
import com.warehouse.adapters.StatisticsDataConverter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "statistics")
@TypeConverters(StatisticsDataConverter.class)
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

    public void setValues(ArrayList<StatisticsValue> values) {
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
