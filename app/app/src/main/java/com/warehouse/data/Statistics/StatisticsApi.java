package com.warehouse.data.Statistics;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StatisticsApi {
    // /statistics/:roomId?period=7
    @GET("/statistics/{id}")
    Call<StatisticsResponse> getStatistics(@Path("id") String id);
}
