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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.warehouse.R;
import com.warehouse.data.User.UserRepository;
import com.warehouse.ui.MainActivity.MainActivityViewModel;
import com.warehouse.ui.home.HomeViewModel;


public class SettingsFragment extends Fragment {
    SettingsViewModel settingsViewModel;
    View root;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settingsViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
        settingsViewModel.init();
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

        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                settingsViewModel.setNotification(isChecked);
            }
        });

        settingsViewModel.getNotification().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isChecked) {
                setSwitchText(isChecked, enabledNotificationText);
                notificationSwitch.setChecked(isChecked);
            }
        });
    }

    private void initDarkModeSwitch() {
        SwitchMaterial nightModeSwitch = root.findViewById(R.id.nightModeSwitch);
        TextView enableThemeModeText = root.findViewById(R.id.ThemeModeToggle);

        nightModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                settingsViewModel.setTheme(isChecked);
            }
        });

        settingsViewModel.getTheme().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isChecked) {
                setSwitchText(isChecked, enableThemeModeText);
                nightModeSwitch.setChecked(isChecked);
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