package com.warehouse.adapters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.warehouse.data.Room.Sensor;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class DataConverter {
    static Gson gson = new Gson();

    @TypeConverter
    public static List<Sensor> toSensorList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Sensor>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String fromSensorList(List<Sensor> sensors) {
        return gson.toJson(sensors);
    }
}
