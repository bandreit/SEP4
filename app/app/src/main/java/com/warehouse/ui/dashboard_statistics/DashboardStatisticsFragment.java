package com.warehouse.ui.dashboard_statistics;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
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

public class DashboardStatisticsFragment extends Fragment {
    public static final String ARG_ROOM_ID = "ROOM_ID";
    private DashboardStatisticsViewModel dashboardStatisticsViewModel;
    private View root;
    private String roomId;
    private LineChart temperatureChart;
    private LineChart humidityChart;
    private BarChart co2Chart;
    private Spinner spinner;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dashboardStatisticsViewModel = new ViewModelProvider(this).get(DashboardStatisticsViewModel.class);

        return inflater.inflate(R.layout.fragment_dashboard_statistics, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        root = view;

        Bundle args = getArguments();
        roomId = args.getString(ARG_ROOM_ID);

        dashboardStatisticsViewModel.init(roomId);

        initStatistics();
        setupFilter();
    }

    private void initStatistics() {
        dashboardStatisticsViewModel.getStatistics().observe(getViewLifecycleOwner(), new Observer<List<Statistics>>() {
            @Override
            public void onChanged(List<Statistics> statistics) {
                if (statistics != null) {
                    setupAverageTemperature();
                    setupAverageHumidity();
                    setupAverageCO2();
                    setupTemperatureChart();
                    setupHumidityChart();
                    setupCO2Chart();
                }
            }
        });
    }

    private void setupFilter() {
        spinner = root.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.filter_dashboard, R.layout.spinner_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setupAverageTemperature() {
        TextView textView = root.findViewById(R.id.temperatureValue);
        Float value = dashboardStatisticsViewModel.getAverageActivity("temperature");

        textView.setText(String.valueOf(value));

    }

    private void setupAverageHumidity() {
        TextView textView = root.findViewById(R.id.humidityValue);
        Float value = dashboardStatisticsViewModel.getAverageActivity("humidity");

        textView.setText(String.valueOf(value));
    }

    private void setupAverageCO2() {
        TextView textView = root.findViewById(R.id.co2Value);
        Float value = dashboardStatisticsViewModel.getAverageActivity("co2");

        textView.setText(String.valueOf(value));
    }


    private void setupTemperatureChart() {
        int myColor = getResources().getColor(R.color.textColor);
        temperatureChart = root.findViewById(R.id.temperatureChart);

        temperatureChart.setMinimumHeight(500);

        temperatureChart.getXAxis().setTextColor(myColor);
        temperatureChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        temperatureChart.getXAxis().setDrawGridLines(false);
        temperatureChart.getXAxis().setLabelRotationAngle(45);
        temperatureChart.getXAxis().setValueFormatter(new DayFormatter(getResources()));
        temperatureChart.getAxisLeft().setTextColor(myColor);
        temperatureChart.getAxisRight().setEnabled(false);
        temperatureChart.getLegend().setEnabled(false);
        temperatureChart.getDescription().setEnabled(false);

        loadTemperatureChartData();
    }



    private void loadTemperatureChartData() {
        HashMap<Integer, Integer> values = dashboardStatisticsViewModel.getActivity("temperature");
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


    private void setupHumidityChart() {
        int myColor = getResources().getColor(R.color.textColor);
        humidityChart = root.findViewById(R.id.humidityChart);

        humidityChart.setMinimumHeight(500);

        humidityChart.getXAxis().setTextColor(myColor);
        humidityChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        humidityChart.getXAxis().setDrawGridLines(false);
        humidityChart.getXAxis().setLabelRotationAngle(45);
        humidityChart.getXAxis().setValueFormatter(new DayFormatter(getResources()));

        humidityChart.getAxisLeft().setTextColor(myColor);

        humidityChart.getAxisRight().setEnabled(false);

        humidityChart.getLegend().setEnabled(false);
        humidityChart.getDescription().setEnabled(false);

        loadHumidityChartData();
    }

    private void loadHumidityChartData() {
        HashMap<Integer, Integer> values = dashboardStatisticsViewModel.getActivity("humidity");
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


    private void setupCO2Chart() {
        int myColor = getResources().getColor(R.color.textColor);
        co2Chart = root.findViewById(R.id.co2Chart);

        co2Chart.setMinimumHeight(500);

        co2Chart.getXAxis().setTextColor(myColor);
        co2Chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        co2Chart.getXAxis().setDrawGridLines(false);
        co2Chart.getXAxis().setLabelRotationAngle(45);
        co2Chart.getXAxis().setValueFormatter(new DayFormatter(getResources()));

        co2Chart.getAxisLeft().setTextColor(myColor);

        co2Chart.getAxisRight().setEnabled(false);

        co2Chart.getLegend().setEnabled(false);
        co2Chart.getDescription().setEnabled(false);

        loadCO2ChartData();
    }

    private void loadCO2ChartData() {
        HashMap<Integer, Integer> values = dashboardStatisticsViewModel.getActivity("co2");
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
}
