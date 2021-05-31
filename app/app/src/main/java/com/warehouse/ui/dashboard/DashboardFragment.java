package com.warehouse.ui.dashboard;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

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
import com.warehouse.data.Room.Statistics;
import com.warehouse.formaters.DayFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DashboardFragment extends Fragment {
    DashboardViewModel dashboardViewModel;
    LineChart temperatureChart;
    LineChart humidityChart;
    BarChart co2Chart;
    View view;
    Spinner spinner;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        setupTemperatureChart();
        setupHumidityChart();
        setupCO2Chart();
        setupFilter();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                }
                if (position == 1) {
                    Toast.makeText(getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                }
                if (position == 2) {
                    Toast.makeText(getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                }
                if (position == 3) {
                    Toast.makeText(getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    private void setupFilter() {
        spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.filter_dashboard, R.layout.spinner_item);
        spinner.setAdapter(adapter);
    }

    private void setupTemperatureChart() {
        temperatureChart = view.findViewById(R.id.temperatureChart);

        temperatureChart.setMinimumHeight(500);

        temperatureChart.getXAxis().setTextColor(Color.WHITE);
        temperatureChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        temperatureChart.getXAxis().setDrawGridLines(false);
        temperatureChart.getXAxis().setLabelRotationAngle(45);
        temperatureChart.getXAxis().setValueFormatter(new DayFormatter(getResources()));
        temperatureChart.getAxisLeft().setTextColor(Color.WHITE);
        temperatureChart.getAxisRight().setEnabled(false);
        temperatureChart.getLegend().setEnabled(false);
        temperatureChart.getDescription().setEnabled(false);

        loadTemperatureChartData();
    }

    private void loadTemperatureChartData() {

        dashboardViewModel.getActivity("temperature").observe(getViewLifecycleOwner(), new Observer<HashMap<Integer, Integer>>() {
            @Override
            public void onChanged(HashMap<Integer, Integer> values) {
                ArrayList<Entry> entries = new ArrayList<>();
                Iterator iterator = values.entrySet().iterator();

                while (iterator.hasNext()) {
                    Map.Entry<Integer, Integer> pair = (Map.Entry) iterator.next();
                    entries.add(new Entry(pair.getKey(), pair.getValue()));
                    iterator.remove();
                }

                // Data set
                LineDataSet dataSet = new LineDataSet(entries, getResources().getString(R.string.chart_temperature));
                dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);


                // configure chart
                LineData data = new LineData(dataSet);


                temperatureChart.setData(data);
                temperatureChart.invalidate();
            }
        });
    }


    private void setupHumidityChart() {
        humidityChart = view.findViewById(R.id.humidityChart);

        humidityChart.setMinimumHeight(500);

        humidityChart.getXAxis().setTextColor(Color.WHITE);
        humidityChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        humidityChart.getXAxis().setDrawGridLines(false);
        humidityChart.getXAxis().setLabelRotationAngle(45);
        humidityChart.getXAxis().setValueFormatter(new DayFormatter(getResources()));

        humidityChart.getAxisLeft().setTextColor(Color.WHITE);

        humidityChart.getAxisRight().setEnabled(false);

        humidityChart.getLegend().setEnabled(false);
        humidityChart.getDescription().setEnabled(false);

        loadHumidityChartData();
    }

    private void loadHumidityChartData() {
        dashboardViewModel.getActivity("humidity").observe(getViewLifecycleOwner(), new Observer<HashMap<Integer, Integer>>() {
            @Override
            public void onChanged(HashMap<Integer, Integer> values) {
                ArrayList<Entry> entries = new ArrayList<>();
                Iterator iterator = values.entrySet().iterator();

                while (iterator.hasNext()) {
                    Map.Entry<Integer, Integer> pair = (Map.Entry) iterator.next();
                    entries.add(new Entry(pair.getKey(), pair.getValue()));
                    iterator.remove();
                }

                // Data set
                LineDataSet dataSet = new LineDataSet(entries, getResources().getString(R.string.chart_temperature));


                // configure chart
                LineData data = new LineData(dataSet);

                humidityChart.setData(data);
                humidityChart.invalidate();
            }
        });
    }



    private void setupCO2Chart() {
        co2Chart = view.findViewById(R.id.co2Chart);

        co2Chart.setMinimumHeight(500);

        co2Chart.getXAxis().setTextColor(Color.WHITE);
        co2Chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        co2Chart.getXAxis().setDrawGridLines(false);
        co2Chart.getXAxis().setLabelRotationAngle(45);
        co2Chart.getXAxis().setValueFormatter(new DayFormatter(getResources()));

        co2Chart.getAxisLeft().setTextColor(Color.WHITE);

        co2Chart.getAxisRight().setEnabled(false);

        co2Chart.getLegend().setEnabled(false);
        co2Chart.getDescription().setEnabled(false);

        loadCO2ChartData();
    }

    private void loadCO2ChartData() {
        dashboardViewModel.getActivity("co2").observe(getViewLifecycleOwner(), new Observer<HashMap<Integer, Integer>>() {
            @Override
            public void onChanged(HashMap<Integer, Integer> values) {
                ArrayList<BarEntry> entries = new ArrayList<>();
                Iterator iterator = values.entrySet().iterator();

                while (iterator.hasNext()) {
                    Map.Entry<Integer, Integer> pair = (Map.Entry) iterator.next();
                    entries.add(new BarEntry(pair.getKey(), pair.getValue()));
                    iterator.remove();
                }

                // Data set
                BarDataSet dataSet = new BarDataSet(entries, getResources().getString(R.string.chart_temperature));


                // configure chart
                BarData data = new BarData(dataSet);


                co2Chart.setData(data);
                co2Chart.invalidate();
            }
        });
    }
}
