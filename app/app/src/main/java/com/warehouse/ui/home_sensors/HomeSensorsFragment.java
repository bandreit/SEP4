package com.warehouse.ui.home_sensors;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.warehouse.R;
import com.warehouse.data.Room.Sensor;

import java.util.ArrayList;

public class HomeSensorsFragment extends Fragment {
    public static final String ARG_OBJECT = "object";
    private RecyclerView recyclerView;
    private SensorsRecyclerViewAdapter sensorsRecyclerViewAdapter;
    private View root;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_sensors, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        root = view;

        Bundle args = getArguments();
        System.out.println("----> " + args.getInt(ARG_OBJECT));

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<Sensor> sensors = new ArrayList<>();

        sensors.add(new Sensor("1", "Sensor 1", "PPM", 10.11, 20.24, 12.12));
        sensors.add(new Sensor("2", "Sensor 2", "PPM", 10.11, 20.24, 12.12));
        sensors.add(new Sensor("3", "Sensor 3", "PPM", 10.11, 20.24, 12.12));
        sensors.add(new Sensor("4", "Sensor 4", "PPM", 10.11, 20.24, 12.12));

        recyclerView = root.findViewById(R.id.sensorsListRV);
        sensorsRecyclerViewAdapter = new SensorsRecyclerViewAdapter(sensors);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.setAdapter(sensorsRecyclerViewAdapter);
    }
}
