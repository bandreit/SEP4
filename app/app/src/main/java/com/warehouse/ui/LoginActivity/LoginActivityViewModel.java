package com.warehouse.ui.LoginActivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.google.firebase.auth.FirebaseUser;
import com.warehouse.data.User.UserRepository;

public class LoginActivityViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);

        this.userRepository = UserRepository.getInstance(application);
    }

    public void login(String email, String password) {
        userRepository.login(email, password);
    }

    public LiveData<FirebaseUser> getUser() {
        return userRepository.getUser();
    }
}
