package com.warehouse.ui.MainActivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;
import com.warehouse.data.Room.Room;
import com.warehouse.data.Room.RoomRepository;
import com.warehouse.data.User.UserRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private RoomRepository roomRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        this.userRepository = UserRepository.getInstance(application);
        this.roomRepository = RoomRepository.getInstance(application);
    }

    public void init() {
        roomRepository.fetchRooms();
    }

    public LiveData<FirebaseUser> getUser() {
        return userRepository.getUser();
    }

    public LiveData<List<Room>> getRooms() {
        return roomRepository.getRooms();
    }
}
