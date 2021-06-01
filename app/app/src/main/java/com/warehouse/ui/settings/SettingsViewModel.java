package com.warehouse.ui.settings;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.warehouse.data.User.UserRepository;

public class SettingsViewModel extends AndroidViewModel {
    MutableLiveData<Boolean> notification;
    MutableLiveData<Boolean> theme;
    UserRepository userRepository;

    public SettingsViewModel(@NonNull Application application){
        super(application);
        notification = new MutableLiveData<Boolean>();
        theme = new MutableLiveData<Boolean>();

        this.userRepository = UserRepository.getInstance(application);
    }
    public LiveData<Boolean> getNotification() {
        return notification;
    }

    public void setNotification(Boolean notificationValue) {
        notification.postValue (notificationValue);
    }

    public LiveData<Boolean> getTheme() {
        return theme;
    }

    public void setTheme(Boolean themeValue) { theme.postValue (themeValue);
    }

    public void logOut() {
        userRepository.signOut();
    }
}
