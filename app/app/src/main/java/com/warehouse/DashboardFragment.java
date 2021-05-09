package com.warehouse;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.warehouse.formaters.DayFormatter;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {
    LineChart temperatureLineChart;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragment_dashboard, container, false);
        setupTemperatureLineChart();

        return view;
    }


    private void setupTemperatureLineChart() {
        temperatureLineChart = view.findViewById(R.id.temperatureChart);

        temperatureLineChart.setMinimumHeight(500);

        temperatureLineChart.getXAxis().setTextColor(Color.WHITE);
        temperatureLineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        temperatureLineChart.getXAxis().setDrawGridLines(false);
        temperatureLineChart.getXAxis().setLabelRotationAngle(45);
        temperatureLineChart.getXAxis().setValueFormatter(new DayFormatter());

        temperatureLineChart.getAxisLeft().setTextColor(Color.WHITE);

        temperatureLineChart.getAxisRight().setEnabled(false);

        temperatureLineChart.getLegend().setEnabled(false);
        temperatureLineChart.getDescription().setEnabled(false);

        loadTemperatureChartData();
    }

    private void loadTemperatureChartData() {
        // Data
        ArrayList<Entry> entries = new ArrayList<>();

        entries.add(new Entry(1, 470));
        entries.add(new Entry(2, 80));
        entries.add(new Entry(3, 2300));
        entries.add(new Entry(4, 1200));
        entries.add(new Entry(5, 5400));
        entries.add(new Entry(6, 9100));
        entries.add(new Entry(7, 2500));


        // Data set
        LineDataSet dataSet = new LineDataSet(entries, "Temperature");


        // configure chart
        LineData data = new LineData(dataSet);


        temperatureLineChart.setData(data);
        temperatureLineChart.invalidate();
    }
}
