package com.warehouse.adapters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.warehouse.data.Statistics.StatisticsValue;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class StatisticsDataConverter {
    static Gson gson = new Gson();

    @TypeConverter
    public List<StatisticsValue> toDataList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<StatisticsValue>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public String fromDataList(List<StatisticsValue> sensors) {
        return gson.toJson(sensors);
    }
}
