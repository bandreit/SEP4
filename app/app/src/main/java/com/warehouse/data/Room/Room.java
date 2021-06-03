package com.warehouse.data.Room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.warehouse.adapters.DataConverter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity(tableName = "rooms_table")
@TypeConverters(DataConverter.class)
public class Room {
    @PrimaryKey
    @NotNull
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
