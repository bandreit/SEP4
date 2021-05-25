package com.warehouse.ui.BoardingActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.warehouse.R;
import com.warehouse.ui.LoginActivity.LoginActivity;

public class BoardingActivity extends AppCompatActivity {

    public static final String BOARDING_PAGE_PREFERENCE = "onBoarding preference";
    public static final String BOARDING_PAGE_COMPLETE = "onBoarding";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.fragment_boarding);

        findViewById (R.id.getStartedBtn).setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BoardingActivity.this, LoginActivity.class));
                SharedPreferences sharedPreferences = getSharedPreferences(BOARDING_PAGE_PREFERENCE, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean (BOARDING_PAGE_COMPLETE,true);
                editor.apply ();
                finish ();
            }
        });
    }
}
