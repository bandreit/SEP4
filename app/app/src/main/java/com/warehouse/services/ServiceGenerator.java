package com.warehouse.services;

import com.warehouse.data.Room.RoomApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static RoomApi roomApi = retrofit.create(RoomApi.class);

    public static RoomApi getRoomApi() {
        return roomApi;
    }
}
