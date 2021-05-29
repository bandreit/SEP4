package com.warehouse.ui.configure;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.slider.RangeSlider;
import com.warehouse.R;
import com.warehouse.data.Room.Sensor;
import com.warehouse.ui.home.HomeViewModel;

public class BottomSheetDialog extends BottomSheetDialogFragment {
    private Sensor sensor;
    private BottomSheetDialogViewModel bottomSheetDialogViewModel;

    public BottomSheetDialog(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bottomSheetDialogViewModel = new ViewModelProvider(this).get(BottomSheetDialogViewModel.class);

        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottom_sheet_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView configureSensorName = view.findViewById(R.id.configureSensorName);
        TextView configureSensorRoom = view.findViewById(R.id.configureSensorRoom);
        RangeSlider rangeSlider = view.findViewById(R.id.configureRangeSlider);

        String roomName = bottomSheetDialogViewModel.findRoomNameBySensorId(sensor.getId());
        Float minValue = (float) Math.round(sensor.getMinValue().floatValue());
        Float maxValue = (float) Math.round(sensor.getMaxValue().floatValue());

        configureSensorName.setText(sensor.getName());
        configureSensorRoom.setText(roomName);

        rangeSlider.setValueFrom(0.0f);
        rangeSlider.setValueTo(100.0f);
        rangeSlider.setValues(minValue, maxValue);
    }
}
