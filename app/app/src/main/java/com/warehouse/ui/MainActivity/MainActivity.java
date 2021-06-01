package com.warehouse.ui.MainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.messaging.FirebaseMessaging;
import com.warehouse.R;
import com.warehouse.ui.LoginActivity.LoginActivity;
import com.warehouse.ui.dashboard.DashboardViewModel;
import com.warehouse.ui.settings.SettingsViewModel;


public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mainActivityViewModel;
    private DashboardViewModel dashboardViewModel;
    private SettingsViewModel settingsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        settingsViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);


        setContentView(R.layout.activity_main);
        startAppActivity();

        checkIfSignedIn();
    }

    public void checkIfSignedIn() {
        mainActivityViewModel.getUser().observe(this, user -> {
            if(user == null) {
                startLoginActivity();
            } else {
                startAppActivity();
            }
        });
    }

    private void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));

        finish();
    }

    public void startAppActivity() {
        BottomNavigationView navView = findViewById(R.id.nav_view);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);


        mainActivityViewModel.init();
        dashboardViewModel.init();
        settingsViewModel.init();
    }
}