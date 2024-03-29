package com.warehouse.ui.home_sensors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.warehouse.R;
import com.warehouse.data.Room.Sensor;
import com.warehouse.ui.configure.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class SensorsRecyclerViewAdapter extends RecyclerView.Adapter<SensorsRecyclerViewAdapter.ViewHolder> {
    List<Sensor> sensors = new ArrayList<>();
    FragmentManager fragmentManager;

    View view;


    public SensorsRecyclerViewAdapter(FragmentManager fragmentManager) {
        this.fragmentManager=fragmentManager;

    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
         view = inflater.inflate(R.layout.home_sensor_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sensor sensor = sensors.get(position);
        String sensorValue = sensor.getCurrentValue() + " " + sensor.getMeasurementUnit();

        holder.sensorName.setText(sensor.getName());
        holder.sensorValue.setText(sensorValue);

        ImageButton configureButton= view.findViewById(R.id.configureBtn);
        ConstraintLayout sensorItem = view.findViewById (R.id.sensorItem);
        sensorItem.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog= new BottomSheetDialog(sensor);
                bottomSheetDialog.show(fragmentManager,"BOTTOM_SHEET_DIALOG");
            }
        });
        configureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog= new BottomSheetDialog(sensor);
                bottomSheetDialog.show(fragmentManager,"BOTTOM_SHEET_DIALOG");
            }
        });
    }

    @Override
    public int getItemCount() {
        return sensors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sensorName;
        TextView sensorValue;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sensorName = itemView.findViewById(R.id.sensorName);
            sensorValue = itemView.findViewById(R.id.sensorValue);
        }
    }
}
