package com.warehouse.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.warehouse.data.Room.Room;
import com.warehouse.ui.home_sensors.HomeSensorsFragment;

import java.util.ArrayList;
import java.util.List;

public class RoomsViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<Room> tabList = new ArrayList<>();

    public RoomsViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new HomeSensorsFragment();
        Bundle args = new Bundle();

        args.putString(HomeSensorsFragment.ARG_ROOM_ID, tabList.get(position).getId());
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

    public void setTabList(List<Room> tabList) {
        this.tabList = tabList;
        this.notifyDataSetChanged();
    }
}
