package com.warehouse.data.Statistics;

public class StatisticsValue {
    private Double value;
    private String timestamp;

    public StatisticsValue(Double value, String timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
