package com.warehouse.ui.settings;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;
import com.warehouse.data.User.UserRepository;

public class SettingsViewModel extends AndroidViewModel {
    MutableLiveData<Boolean> notification;
    MutableLiveData<Boolean> theme;
    SharedPreferences sharedPreferences;
    UserRepository userRepository;
    FirebaseMessaging firebaseMessagingInstance;

    public SettingsViewModel(@NonNull Application application) {
        super(application);
        notification = new MutableLiveData<Boolean>(false);
        theme = new MutableLiveData<Boolean>(false);

        this.userRepository = UserRepository.getInstance(application);
        this.firebaseMessagingInstance = FirebaseMessaging.getInstance();
        this.sharedPreferences = getApplication().getSharedPreferences("settings", Context.MODE_PRIVATE);
    }

    public void init() {
        Boolean notificationsEnabled = sharedPreferences.getBoolean("notifications_enabled", true);
        Boolean darkModeEnabled = sharedPreferences.getBoolean("dark_mode_enabled", true);

        setNotification(notificationsEnabled);
        setTheme(darkModeEnabled);
    }

    public LiveData<Boolean> getNotification() {
        return notification;
    }

    public void setNotification(Boolean isChecked) {
        notification.setValue(isChecked);

        if (isChecked) {
            firebaseMessagingInstance.subscribeToTopic("notifications");
        } else {
            firebaseMessagingInstance.unsubscribeFromTopic("notifications");
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("notifications_enabled", isChecked);
        editor.apply();
    }

    public LiveData<Boolean> getTheme() {
        return theme;
    }

    public void setTheme(Boolean isChecked) {
        theme.setValue(isChecked);

        AppCompatDelegate.setDefaultNightMode(isChecked ? AppCompatDelegate.MODE_NIGHT_NO : AppCompatDelegate.MODE_NIGHT_YES);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("dark_mode_enabled", isChecked);
        editor.apply();
    }

    public void logOut() {
        userRepository.signOut();
    }
}
