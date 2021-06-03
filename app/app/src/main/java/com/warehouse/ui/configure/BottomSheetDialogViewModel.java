package com.warehouse.ui.configure;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.warehouse.data.Room.Room;
import com.warehouse.data.Room.RoomRepository;
import com.warehouse.data.Room.Sensor;

import java.util.List;

public class BottomSheetDialogViewModel extends AndroidViewModel {
    private RoomRepository roomRepository;

    public BottomSheetDialogViewModel(@NonNull Application application) {
        super(application);

        this.roomRepository = RoomRepository.getInstance(application);
    }

    public String findRoomNameBySensorId(String sensorId) {
        List<Room> rooms = roomRepository.getRooms().getValue();

        for (Room room : rooms) {
            for (Sensor sensor : room.getSensors()) {
                if (sensor.getId().equals(sensorId)) {
                    return room.getName();
                }
            }
        }

        return "";
    }

    public void updateSensorMinMax(String sensorId, Double min, Double max) {
        List<Room> rooms =  roomRepository.getRooms ().getValue();
        for (Room room : rooms) {
            for (Sensor sensor : room.getSensors()) {
                if (sensor.getId().equals(sensorId)) {
                    if(sensor != null) {
                        sensor.setMaxValue (max);
                        sensor.setMinValue (min);
                        roomRepository.updateSensor (sensorId,sensor);
                    }
                }
            }
        }
    }
}
