package com.warehouse.ui.home_sensors;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.warehouse.R;
import com.warehouse.data.Room.Room;
import com.warehouse.data.Room.Sensor;
import com.warehouse.ui.home.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeSensorsFragment extends Fragment {
    public static final String ARG_ROOM_ID = "ROOM_ID";
    private HomeSensorsViewModel homeSensorsViewModel;
    private RecyclerView recyclerView;
    private SensorsRecyclerViewAdapter sensorsRecyclerViewAdapter;
    private View root;
    private String roomId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        homeSensorsViewModel = new ViewModelProvider(this).get(HomeSensorsViewModel.class);

        return inflater.inflate(R.layout.fragment_home_sensors, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        root = view;

        Bundle args = getArguments();
        roomId = args.getString(ARG_ROOM_ID);

        initRecyclerView();
        watchSensorsChange();
    }


    private void initRecyclerView() {
        recyclerView = root.findViewById(R.id.sensorsListRV);
        sensorsRecyclerViewAdapter = new SensorsRecyclerViewAdapter(this.getFragmentManager());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.setAdapter(sensorsRecyclerViewAdapter);
    }

    private void watchSensorsChange() {
        homeSensorsViewModel.getRooms().observe(getViewLifecycleOwner(), new Observer<List<Room>>() {
            @Override
            public void onChanged(List<Room> rooms) {
                for (Room room : rooms) {
                    if (room.getId() == roomId) {
                        sensorsRecyclerViewAdapter.setSensors(room.getSensors());
                    }
                }
            }
        });
    }
}
