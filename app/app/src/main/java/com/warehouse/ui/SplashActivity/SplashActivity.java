package com.warehouse.ui.SplashActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.warehouse.R;
import com.warehouse.ui.LoginActivity.LoginActivity;
import com.warehouse.ui.MainActivity.MainActivity;
import com.warehouse.ui.MainActivity.MainActivityViewModel;
import com.warehouse.ui.dashboard.DashboardViewModel;
import com.warehouse.ui.settings.SettingsViewModel;

public class SplashActivity extends AppCompatActivity {
    SplashActivityViewModel splashActivityViewModel;
    SettingsViewModel settingsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        splashActivityViewModel = new ViewModelProvider(this).get(SplashActivityViewModel.class);
        settingsViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);

        setContentView(R.layout.activity_splash);

        settingsViewModel.init();
        checkIfSignedIn();
    }

    public void checkIfSignedIn() {
        splashActivityViewModel.getUser().observe(this, user -> {
            if (user == null) {
                startLoginActivity();
            } else {
                startMainActivity();
            }
        });
    }

    private void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void startMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
