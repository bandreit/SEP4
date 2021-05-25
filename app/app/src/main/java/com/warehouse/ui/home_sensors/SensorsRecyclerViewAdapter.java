package com.warehouse.ui.home_sensors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.warehouse.R;
import com.warehouse.data.Room.Sensor;

import java.util.ArrayList;
import java.util.List;

public class SensorsRecyclerViewAdapter extends RecyclerView.Adapter<SensorsRecyclerViewAdapter.ViewHolder> {
    List<Sensor> sensors = new ArrayList<>();

    public SensorsRecyclerViewAdapter(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.home_sensor_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sensorName.setText(sensors.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return sensors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sensorName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sensorName = itemView.findViewById(R.id.sensorName);
        }
    }
}
