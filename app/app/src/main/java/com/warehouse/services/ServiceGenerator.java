package com.warehouse.services;

import com.warehouse.data.Room.RoomsApi;
import com.warehouse.data.Statistics.StatisticsApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static final Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://816ac34414a9.ngrok.io/SEP4/")
            .addConverterFactory(GsonConverterFactory.create());

    private static final Retrofit retrofit = retrofitBuilder.build();

    private static final RoomsApi ROOMS_API = retrofit.create(RoomsApi.class);

    private static final StatisticsApi statisticsApi = retrofit.create (StatisticsApi.class);

    public static RoomsApi getRoomsApi() {
        return ROOMS_API;
    }

    public static StatisticsApi getStatisticsApi(){
        return statisticsApi;
    }
}
