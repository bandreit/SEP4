package com.warehouse.data.Room;

import java.util.List;

public class RoomsResponse {
    private List<Room> data;

    public List<Room> getData() {
        return data;
    }

    public void setData(List<Room> data) {
        this.data = data;
    }

    private class Room {
        private String id;
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

    private class Sensor {
        private String id;
        private String name;
        private String measurementUnit;
        private Double minValue;
        private Double maxValue;
        private Double currentValue;

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
    }
}




