package com.warehouse.ui.dashboard;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.warehouse.data.Room.Room;
import com.warehouse.data.Room.RoomRepository;
import com.warehouse.data.Room.Statistics;
import com.warehouse.data.Room.StatisticsRepository;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Observable;

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
