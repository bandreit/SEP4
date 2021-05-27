package com.warehouse.formaters;

import android.content.res.Resources;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.warehouse.R;

public class DayFormatter extends ValueFormatter {
    private Resources resources;
    
    public DayFormatter(Resources resources) {
        this.resources = resources;
    }
    
    @Override
    public String getFormattedValue(float value) {
        switch (Math.round(value)) {
            case 1:
                return resources.getString(R.string.day_monday);
            case 2:
                return resources.getString(R.string.day_tuesday);
            case 3:
                return resources.getString(R.string.day_wednesday);
            case 4:
                return resources.getString(R.string.day_thursday);
            case 5:
                return resources.getString(R.string.day_friday);
            case 6:
                return resources.getString(R.string.day_saturday);
            case 7:
                return resources.getString(R.string.day_sunday);
            default:
                return String.valueOf(value);
        }
    }
}