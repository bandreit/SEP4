package com.warehouse.ui.dashboard;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.material.tabs.TabLayout;
import com.warehouse.R;
import com.warehouse.adapters.RoomsViewPagerAdapter;
import com.warehouse.data.Room.Room;
import com.warehouse.data.Room.Statistics;
import com.warehouse.formaters.DayFormatter;
import com.warehouse.ui.dashboard_statistics.DashboardStatisticsFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DashboardFragment extends Fragment {
    DashboardViewModel dashboardViewModel;
    TabLayout roomsTabLayout;
    ViewPager roomsViewPager;
    ScrollView dashboardContainerSV;
    View root;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        root = view;

        setupViewPager();
    }

    private void setupViewPager() {
        roomsTabLayout = root.findViewById(R.id.roomsTabLayout);
        roomsViewPager = root.findViewById(R.id.roomsViewPager);
        dashboardContainerSV = root.findViewById(R.id.dashboardContainerSV);

        RoomsViewPagerAdapter adapter = new RoomsViewPagerAdapter(getChildFragmentManager(), DashboardStatisticsFragment.class);

        dashboardViewModel.getRooms().observe(getViewLifecycleOwner(), new Observer<List<Room>>() {
            @Override
            public void onChanged(List<Room> rooms) {
                adapter.setTabList(rooms);
            }
        });



        roomsViewPager.setAdapter(adapter);
        roomsTabLayout.setupWithViewPager(roomsViewPager);
    }


}
