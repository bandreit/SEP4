package com.warehouse.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SensorsResponse {
    private String sensorName;
    private String unitType;
    private Double value;
    private String timestamp;

    public Sensor getSensor() {
        return new Sensor(sensorName, unitType, value, timestamp);
    }
}
