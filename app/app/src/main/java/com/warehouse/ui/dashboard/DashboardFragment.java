package com.warehouse.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.warehouse.R;
import com.warehouse.adapters.RoomsViewPagerAdapter;
import com.warehouse.data.Room.Room;
import com.warehouse.ui.dashboard_statistics.DashboardStatisticsFragment;

import java.util.List;

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
