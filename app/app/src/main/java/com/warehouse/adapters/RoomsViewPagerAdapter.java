package com.warehouse.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.warehouse.ui.home_sensors.HomeSensorsFragment;

import java.util.ArrayList;
import java.util.List;

public class RoomsViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<RoomTab> tabList = new ArrayList<>();

    public RoomsViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new HomeSensorsFragment();
        Bundle args = new Bundle();

        args.putInt(HomeSensorsFragment.ARG_OBJECT, position + 1);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getCount() {
        return tabList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabList.get(position).getName();
    }

    public void addTab(RoomTab tab) {
        tabList.add(tab);
    }

    public static class RoomTab {
        public RoomTab(String id, String name) {
            this.id = id;
            this.name = name;
        }

        private String id;
        private String name;

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }
    }
}
