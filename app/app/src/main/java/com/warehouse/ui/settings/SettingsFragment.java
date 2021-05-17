package com.warehouse.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.warehouse.R;


public class SettingsFragment extends Fragment {
    SwitchMaterial notificationSwitch, themeModeSwitch;
    TextView enabledNotification, enableThemeMode;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        notificationSwitch = view.findViewById (R.id.notificationSwitch);
        themeModeSwitch = view.findViewById (R.id.themeModeSwitch);

        enabledNotification = view.findViewById (R.id.NotificationsToggle);
        enableThemeMode = view.findViewById (R.id.ThemeModeToggle);

        notificationSwitch.setChecked (true);

        notificationSwitch.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener ( ) {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    enabledNotification.setText (R.string.title_enabled);
                }
                else {
                    enabledNotification.setText (R.string.title_disabled);
                }
            }
        });

        themeModeSwitch.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener ( ) {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    enableThemeMode.setText (R.string.title_enabled);
                }
                else {
                    enableThemeMode.setText (R.string.title_disabled);
                }
            }
        });

        return view;
    }
}