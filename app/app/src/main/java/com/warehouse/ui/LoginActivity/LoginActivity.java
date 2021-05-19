package com.warehouse.ui.LoginActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.warehouse.R;
import com.warehouse.ui.MainActivity.MainActivity;

public class LoginActivity extends AppCompatActivity {
    private LoginActivityViewModel loginActivityViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginActivityViewModel = new ViewModelProvider(this).get(LoginActivityViewModel.class);

        checkIfSignedIn();

        setContentView(R.layout.activity_login);

        findViewById(R.id.loginBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        TextView email = findViewById(R.id.login_email);
        TextView password = findViewById(R.id.login_password);

        loginActivityViewModel.login(email.getText().toString(), password.getText().toString());
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
