package com.warehouse.ui.MainActivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;
import com.warehouse.data.User.UserRepository;

public class MainActivityViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        this.userRepository = UserRepository.getInstance(application);
    }

    public void init() {
    }

    public LiveData<FirebaseUser> getUser() {
        return userRepository.getUser();
    }
}
