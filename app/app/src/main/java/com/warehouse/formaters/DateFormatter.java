package com.warehouse.formaters;

import android.content.res.Resources;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.warehouse.R;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateFormatter extends ValueFormatter {
    private Resources resources;
    
    public DateFormatter(Resources resources) {
        this.resources = resources;
    }
    
    @Override
    public String getFormattedValue(float value) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM HH:mm", Locale.ENGLISH);
        return sdf.format(value);
    }
}