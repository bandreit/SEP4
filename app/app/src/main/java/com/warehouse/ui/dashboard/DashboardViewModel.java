package com.warehouse.ui.dashboard;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.warehouse.data.Room.Room;
import com.warehouse.data.Room.RoomRepository;

import java.util.List;

public class DashboardViewModel extends AndroidViewModel {
    private RoomRepository roomRepository;

    public DashboardViewModel(@NonNull Application application) {
        super(application);

        this.roomRepository = RoomRepository.getInstance(application);
    }

    public void init() {}

    public LiveData<List<Room>> getRooms() {
        return roomRepository.getRooms();
    }
}
