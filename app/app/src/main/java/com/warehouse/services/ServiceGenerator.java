package com.warehouse.services;

import com.warehouse.data.Room.RoomApi;
import com.warehouse.data.Statistics.StatisticsApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static final Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create());

    private static final Retrofit retrofit = retrofitBuilder.build();

    private static final RoomApi roomApi = retrofit.create(RoomApi.class);

    private static final StatisticsApi statisticsApi = retrofit.create (StatisticsApi.class);

    public static RoomApi getRoomApi() {
        return roomApi;
    }

    public static StatisticsApi getStatisticsApi(){
        return statisticsApi;
    }
}
