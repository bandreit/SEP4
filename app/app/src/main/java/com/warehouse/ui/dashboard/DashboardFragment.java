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

import androidx.activity.OnBackPressedDispatcherOwner;
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
import java.util.Observable;

public class DashboardFragment extends Fragment {
    DashboardViewModel dashboardViewModel;
    LineChart temperatureChart;
    LineChart humidityChart;
    BarChart co2Chart;
    View view;
    Spinner spinner;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        dashboardViewModel = new ViewModelProvider (this).get(DashboardViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        setupTemperatureChart();
        setupHumidityChart();
        setupCO2Chart();
        setupFilter();

        spinner.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener ( ) {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText (getContext (),String.valueOf (position),Toast.LENGTH_SHORT).show ();
                }
                if(position == 1){
                    Toast.makeText (getContext (),String.valueOf (position),Toast.LENGTH_SHORT).show ();
                }
                if(position == 2){
                    Toast.makeText (getContext (),String.valueOf (position),Toast.LENGTH_SHORT).show ();
                }
                if(position == 3){
                    Toast.makeText (getContext (),String.valueOf (position),Toast.LENGTH_SHORT).show ();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        return view;
    }

    private void setupFilter() {
        spinner = view.findViewById (R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext (), R.array.filter_dashboard, R.layout.spinner_item);
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
        // Data
//        ArrayList<Entry> entries = new ArrayList<>();
//
//        entries.add(new Entry(1, 470));
//        entries.add(new Entry(2, 80));
//        entries.add(new Entry(3, 2300));
//        entries.add(new Entry(4, 1200));
//        entries.add(new Entry(5, 5400));
//        entries.add(new Entry(6, 9100));
//        entries.add(new Entry(7, 2500));


        // Data set
        LineDataSet dataSet = new LineDataSet(getTemperatureEntries (), getResources().getString(R.string.chart_temperature));
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);


        // configure chart
        LineData data = new LineData(dataSet);


        temperatureChart.setData(data);
        temperatureChart.invalidate();
    }

    private List<Entry> getTemperatureEntries(){
        dashboardViewModel.getStatistics ().observe (getViewLifecycleOwner (), new Observer<List<Statistics>> ( ) {
            @Override
            public void onChanged(List<Statistics> statistics) {
                dashboardViewModel.getActivity ("temperature");
            }
        });

        ArrayList<Entry> entries = new ArrayList<>();
        Iterator iterator = dashboardViewModel.getActivity ("temperature").entrySet().iterator ();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> pair = (Map.Entry) iterator.next ( );
            entries.add (new Entry (pair.getKey ( ), pair.getValue ( )));
            iterator.remove ( );
        }

        return entries;
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
        // Data
//        ArrayList<Entry> entries = new ArrayList<>();
//
//        entries.add(new Entry(1, 470));
//        entries.add(new Entry(2, 80));
//        entries.add(new Entry(3, 2300));
//        entries.add(new Entry(4, 1200));
//        entries.add(new Entry(5, 5400));
//        entries.add(new Entry(6, 9100));
//        entries.add(new Entry(7, 2500));


        // Data set
        LineDataSet dataSet = new LineDataSet(getHumidityEntries (), getResources().getString(R.string.chart_temperature));


        // configure chart
        LineData data = new LineData(dataSet);


        humidityChart.setData(data);
        humidityChart.invalidate();
    }

    private List<Entry> getHumidityEntries(){
        ArrayList<Entry> entries = new ArrayList<>();

        Iterator iterator = dashboardViewModel.getActivity ("humidity").entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> pair = (Map.Entry) iterator.next ( );
            entries.add (new Entry (pair.getKey ( ), pair.getValue ( )));
            iterator.remove ( );
        }
        return entries;
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
        // Data
//        ArrayList<BarEntry> entries = new ArrayList<>();
//
//        entries.add(new BarEntry(1, 470));
//        entries.add(new BarEntry(2, 80));
//        entries.add(new BarEntry(3, 2300));
//        entries.add(new BarEntry(4, 1200));
//        entries.add(new BarEntry(5, 5400));
//        entries.add(new BarEntry(6, 9100));
//        entries.add(new BarEntry(7, 2500));


        // Data set
        BarDataSet dataSet = new BarDataSet(getCo2Entries (), getResources().getString(R.string.chart_temperature));


        // configure chart
        BarData data = new BarData(dataSet);


        co2Chart.setData(data);
        co2Chart.invalidate();
    }

    private List<BarEntry> getCo2Entries(){
        ArrayList<BarEntry> entries = new ArrayList<>();

        Iterator iterator = dashboardViewModel.getActivity ("co2").entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> pair = (Map.Entry) iterator.next ( );
            entries.add (new BarEntry (pair.getKey ( ), pair.getValue ( )));
            iterator.remove ( );
        }
        return entries;
    }
}
