package com.warehouse.ui.SplashActivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.google.firebase.auth.FirebaseUser;
import com.warehouse.data.Room.Room;
import com.warehouse.data.Room.RoomRepository;
import com.warehouse.data.User.UserRepository;

import java.util.List;

public class SplashActivityViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    public SplashActivityViewModel(@NonNull Application application) {
        super(application);

        this.userRepository = UserRepository.getInstance(application);
    }

    public void init() {
    }

    public LiveData<FirebaseUser> getUser() {
        return userRepository.getUser();
    }

}
