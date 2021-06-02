package com.warehouse.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

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
import com.warehouse.ui.MainActivity.MainActivityViewModel;
import com.warehouse.ui.home_sensors.HomeSensorsFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    HomeViewModel homeViewModel;
    TabLayout roomsTabLayout;
    ViewPager roomsViewPager;
    View root;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
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

        RoomsViewPagerAdapter adapter = new RoomsViewPagerAdapter(getChildFragmentManager(), HomeSensorsFragment.class);

        homeViewModel.getRooms().observe(getViewLifecycleOwner(), new Observer<List<Room>>() {
            @Override
            public void onChanged(List<Room> rooms) {
                adapter.setTabList(rooms);
            }
        });

        roomsViewPager.setAdapter(adapter);
        roomsTabLayout.setupWithViewPager(roomsViewPager);
    }


}
