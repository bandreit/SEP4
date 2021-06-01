package com.warehouse.ui.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.warehouse.R;
import com.warehouse.data.User.UserRepository;
import com.warehouse.ui.MainActivity.MainActivityViewModel;
import com.warehouse.ui.home.HomeViewModel;


public class SettingsFragment extends Fragment {
    SettingsViewModel settingsViewModel;
    SharedPreferences sharedPreferences;
    View root;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settingsViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
        sharedPreferences = this.getContext().getSharedPreferences("night_mode", 0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        root = view;

        initNotificationsSwitch();
        initDarkModeSwitch();
        initLogoutBtn();
    }

    private void initNotificationsSwitch() {
        SwitchMaterial notificationSwitch = root.findViewById(R.id.notificationSwitch);
        TextView enabledNotificationText = root.findViewById(R.id.NotificationsToggle);

        notificationSwitch.setChecked(true);

        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setSwitchText(isChecked, enabledNotificationText);
                settingsViewModel.setNotification(isChecked);
            }
        });
    }

    private void initDarkModeSwitch() {
        SwitchMaterial nightModeSwitch = root.findViewById(R.id.nightModeSwitch);
        TextView enableThemeModeText = root.findViewById(R.id.ThemeModeToggle);

        nightModeSwitch.setChecked(true);

        nightModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setSwitchText(isChecked, enableThemeModeText);
                settingsViewModel.setTheme(isChecked);

                AppCompatDelegate.setDefaultNightMode(isChecked ? AppCompatDelegate.MODE_NIGHT_NO : AppCompatDelegate.MODE_NIGHT_YES);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("night_mode", isChecked);
                editor.apply();
            }
        });
    }

    private void initLogoutBtn() {
        ImageButton logOutButton = root.findViewById(R.id.logOutBtn);

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsViewModel.logOut();
            }
        });
    }

    private void setSwitchText(boolean isChecked, TextView textView) {
        textView.setText(isChecked ? R.string.title_enabled : R.string.title_disabled);
    }
}