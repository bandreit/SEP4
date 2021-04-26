package com.warehouse.api;

public class Sensor {
    private String sensorName;
    private String unitType;
    private Double value;
    private String timestamp;


    public Sensor(String sensorName, String unitType, Double value, String timestamp) {
        this.sensorName = sensorName;
        this.unitType = unitType;
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
