package com.warehouse.data.Statistics;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StatisticsApi {
    // sensorHistory/{sensorId}?period=2
//    Call<StatisticsResponse> getStatistics(@Path("sensorId") String sensorId, @Query("period") String period);
    @GET("38e9d0f6-fa32-453f-8379-a9f6973b2730")
    Call<StatisticsResponse> getStatistics();
}
