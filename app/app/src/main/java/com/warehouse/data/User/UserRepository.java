package com.warehouse.data.User;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserRepository {
    private UserLiveData user;
    private static UserRepository instance;
    private FirebaseAuth mAuth;
    private Application application;

    private UserRepository() {
        user = new UserLiveData();
    }

    public static synchronized UserRepository getInstance(Application application) {
        if (instance == null) {
            instance = new UserRepository();
        }

        instance.application = application;
        instance.mAuth = FirebaseAuth.getInstance();

        return instance;
    }

    public LiveData<FirebaseUser> getUser() {
        return user;
    }

    public void signOut() {
        mAuth.signOut();
    }

    public void login(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(application.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
