package com.warehouse.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.warehouse.R;
import com.warehouse.data.Room.Room;
import com.warehouse.ui.home_sensors.HomeSensorsFragment;

import java.util.ArrayList;
import java.util.List;

public class RoomsViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<Room> tabList = new ArrayList<>();
    private Class fragmentClass;

    public RoomsViewPagerAdapter(@NonNull FragmentManager fm, Class fragmentClass) {
        super(fm);
        this.fragmentClass = fragmentClass;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        Bundle args = new Bundle();

        try {
            fragment = (Fragment) fragmentClass.newInstance();

            args.putString(HomeSensorsFragment.ARG_ROOM_ID, tabList.get(position).getId());
            fragment.setArguments(args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


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
