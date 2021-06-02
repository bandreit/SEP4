package com.warehouse.ui.home_sensors;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.warehouse.data.Room.Room;
import com.warehouse.data.Room.RoomRepository;

import java.util.List;

public class HomeSensorsViewModel extends AndroidViewModel {
    private RoomRepository roomRepository;

    public HomeSensorsViewModel(@NonNull Application application) {
        super(application);

        this.roomRepository = RoomRepository.getInstance(application);
    }

    public LiveData<List<Room>> getRooms() {
        return roomRepository.getRooms();
    }
}