package com.warehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.warehouse.api.SensorsClient;
import com.warehouse.api.SensorsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navSelectedListener);

        // load the home fragment when the app starts
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://9d736cd395f7.ngrok.io/SEP4/")
//                .addConverterFactory(GsonConverterFactory.create()).build();
//
//        SensorsClient sensorsClient = retrofit.create(SensorsClient.class);
//        Call<SensorsResponse> call = sensorsClient.getParameters();
//
//        call.enqueue(new Callback<SensorsResponse>() {
//            @Override
//            public void onResponse(Call<SensorsResponse> call, Response<SensorsResponse> response) {
//                SensorsResponse temperature = response.body();
//                TextView temperatureValueTextView = (TextView) findViewById(R.id.temperatureValue);
//                temperatureValueTextView.setText("" + temperature.getSensor().getValue());
//            }
//
//            @Override
//            public void onFailure(Call<SensorsResponse> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navigation_dashboard:
                    selectedFragment = new DashboardFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        }
    };


}