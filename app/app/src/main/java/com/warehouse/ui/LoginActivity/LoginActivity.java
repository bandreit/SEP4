package com.warehouse.ui.LoginActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.warehouse.R;
import com.warehouse.ui.BoardingActivity.BoardingActivity;
import com.warehouse.ui.MainActivity.MainActivity;
import com.warehouse.ui.loading.LoadingDialog;

import static com.warehouse.ui.BoardingActivity.BoardingActivity.BOARDING_PAGE_COMPLETE;
import static com.warehouse.ui.BoardingActivity.BoardingActivity.BOARDING_PAGE_PREFERENCE;

public class LoginActivity extends AppCompatActivity {
    private LoginActivityViewModel loginActivityViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = this.getSharedPreferences(BOARDING_PAGE_PREFERENCE, MODE_PRIVATE);
        if (!sharedPreferences.getBoolean(BOARDING_PAGE_COMPLETE, false)) {
            startActivity(new Intent(this, BoardingActivity.class));
            finish ();
        }

        loginActivityViewModel = new ViewModelProvider(this).get(LoginActivityViewModel.class);

        checkIfSignedIn();

        setContentView(R.layout.activity_login);

        final LoadingDialog loadingDialog=new LoadingDialog(LoginActivity.this);

        findViewById(R.id.loginBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadingDialog.startLoadingDialog();

                login();
            }
        });
    }

    private void login() {
        TextView email = findViewById(R.id.login_email);
        TextView password = findViewById(R.id.login_password);

        if(TextUtils.isEmpty (email.getText ()) || TextUtils.isEmpty (password.getText ())) {
            if(TextUtils.isEmpty (email.getText ())){
                email.setError(getResources().getString(R.string.validation_email_required));
            }
            if(TextUtils.isEmpty (password.getText ())) {
                password.setError(getResources().getString(R.string.validation_password_required));
            }
        }
        else loginActivityViewModel.login(email.getText().toString(), password.getText().toString());
    }

    private void goToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void checkIfSignedIn() {
        loginActivityViewModel.getUser().observe(this, user -> {
            if (user != null) {
                goToMainActivity();
            }
        });
    }

}
