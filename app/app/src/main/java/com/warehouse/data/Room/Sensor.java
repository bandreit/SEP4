package com.warehouse.data.Room;

import com.google.gson.annotations.SerializedName;

public class Sensor {
    @SerializedName("sensorID")
    private String id;
    @SerializedName("sensorType")
    private String name;
    @SerializedName("unitType")
    private String measurementUnit;
    @SerializedName("minValue")
    private Double minValue;
    @SerializedName("maxValue")
    private Double maxValue;
    @SerializedName("currentvalue")
    private Double currentValue;


    public Sensor(String id, String name, String measurementUnit, Double minValue, Double maxValue, Double currentValue) {
        this.id = id;
        this.name = name;
        this.measurementUnit = measurementUnit;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.currentValue = currentValue;
    }

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

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

}
