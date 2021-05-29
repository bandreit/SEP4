package com.warehouse.services;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;

public class FirebaseInstanceIdService extends FirebaseMessagingService {
    @Override
    public void onNewToken(@NonNull String token) {
    }

}
