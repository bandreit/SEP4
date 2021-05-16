package com.warehouse.ui.dashboard;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.warehouse.R;
import com.warehouse.formaters.DayFormatter;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {
    LineChart temperatureChart;
    LineChart humidityChart;
    BarChart co2Chart;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        setupTemperatureChart();
        setupHumidityChart();
        setupCO2Chart();

        return view;
    }

    private void setupTemperatureChart() {
        temperatureChart = view.findViewById(R.id.temperatureChart);

        temperatureChart.setMinimumHeight(500);

        temperatureChart.getXAxis().setTextColor(Color.WHITE);
        temperatureChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        temperatureChart.getXAxis().setDrawGridLines(false);
        temperatureChart.getXAxis().setLabelRotationAngle(45);
        temperatureChart.getXAxis().setValueFormatter(new DayFormatter());

        temperatureChart.getAxisLeft().setTextColor(Color.WHITE);

        temperatureChart.getAxisRight().setEnabled(false);

        temperatureChart.getLegend().setEnabled(false);
        temperatureChart.getDescription().setEnabled(false);

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
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);


        // configure chart
        LineData data = new LineData(dataSet);


        temperatureChart.setData(data);
        temperatureChart.invalidate();
    }

    private void setupHumidityChart() {
        humidityChart = view.findViewById(R.id.humidityChart);

        humidityChart.setMinimumHeight(500);

        humidityChart.getXAxis().setTextColor(Color.WHITE);
        humidityChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        humidityChart.getXAxis().setDrawGridLines(false);
        humidityChart.getXAxis().setLabelRotationAngle(45);
        humidityChart.getXAxis().setValueFormatter(new DayFormatter());

        humidityChart.getAxisLeft().setTextColor(Color.WHITE);

        humidityChart.getAxisRight().setEnabled(false);

        humidityChart.getLegend().setEnabled(false);
        humidityChart.getDescription().setEnabled(false);

        loadHumidityChartData();
    }

    private void loadHumidityChartData() {
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


        humidityChart.setData(data);
        humidityChart.invalidate();
    }


    private void setupCO2Chart() {
        co2Chart = view.findViewById(R.id.co2Chart);

        co2Chart.setMinimumHeight(500);

        co2Chart.getXAxis().setTextColor(Color.WHITE);
        co2Chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        co2Chart.getXAxis().setDrawGridLines(false);
        co2Chart.getXAxis().setLabelRotationAngle(45);
        co2Chart.getXAxis().setValueFormatter(new DayFormatter());

        co2Chart.getAxisLeft().setTextColor(Color.WHITE);

        co2Chart.getAxisRight().setEnabled(false);

        co2Chart.getLegend().setEnabled(false);
        co2Chart.getDescription().setEnabled(false);

        loadCO2ChartData();
    }

    private void loadCO2ChartData() {
        // Data
        ArrayList<BarEntry> entries = new ArrayList<>();

        entries.add(new BarEntry(1, 470));
        entries.add(new BarEntry(2, 80));
        entries.add(new BarEntry(3, 2300));
        entries.add(new BarEntry(4, 1200));
        entries.add(new BarEntry(5, 5400));
        entries.add(new BarEntry(6, 9100));
        entries.add(new BarEntry(7, 2500));


        // Data set
        BarDataSet dataSet = new BarDataSet(entries, "Temperature");


        // configure chart
        BarData data = new BarData(dataSet);


        co2Chart.setData(data);
        co2Chart.invalidate();
    }
}
