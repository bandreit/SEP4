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
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.warehouse.R;
import com.warehouse.adapters.RoomsViewPagerAdapter;

public class HomeFragment extends Fragment {
    TabLayout roomsTabLayout;
    ViewPager roomsViewPager;
    View root;

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

        RoomsViewPagerAdapter adapter = new RoomsViewPagerAdapter(getChildFragmentManager());

        adapter.addTab(new RoomsViewPagerAdapter.RoomTab("tab_1", "Tab 1"));
        adapter.addTab(new RoomsViewPagerAdapter.RoomTab("tab_2", "Tab 2"));
        adapter.addTab(new RoomsViewPagerAdapter.RoomTab("tab_3", "Tab 3"));


        roomsViewPager.setAdapter(adapter);
        roomsTabLayout.setupWithViewPager(roomsViewPager);
    }


}
