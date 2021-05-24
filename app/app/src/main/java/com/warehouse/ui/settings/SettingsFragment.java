package com.warehouse.ui.settings;

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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.warehouse.R;
import com.warehouse.data.User.UserRepository;
import com.warehouse.ui.MainActivity.MainActivityViewModel;


public class SettingsFragment extends Fragment {
    SwitchMaterial notificationSwitch, themeModeSwitch;
    TextView enabledNotification, enableThemeMode;
    SettingsViewModel settingsViewModel;
    ImageButton logOutButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        settingsViewModel = new ViewModelProvider (requireActivity ()).get(SettingsViewModel.class);

        notificationSwitch = view.findViewById (R.id.notificationSwitch);
        themeModeSwitch = view.findViewById (R.id.themeModeSwitch);

        enabledNotification = view.findViewById (R.id.NotificationsToggle);
        enableThemeMode = view.findViewById (R.id.ThemeModeToggle);

        logOutButton = view.findViewById (R.id.logOutBtn);

        notificationSwitch.setChecked (true);

        notificationSwitch.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener ( ) {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switchMode (isChecked, enabledNotification);
                settingsViewModel.setNotification (isChecked);
            }
        });

        themeModeSwitch.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener ( ) {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switchMode (isChecked, enableThemeMode);
                settingsViewModel.setTheme ( isChecked );
            }
        });

        logOutButton.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                settingsViewModel.logOut ();
            }
        });
        return view;
    }

    private void switchMode(boolean isChecked, TextView enabledNotification) {
        if (isChecked) {
            enabledNotification.setText (R.string.title_enabled);
        } else {
            enabledNotification.setText (R.string.title_disabled);
        }
    }
}