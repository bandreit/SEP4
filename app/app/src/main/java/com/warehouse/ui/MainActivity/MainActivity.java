package com.warehouse.ui.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.warehouse.R;
import com.warehouse.ui.LoginActivity.LoginActivity;


public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init();

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
    }
}