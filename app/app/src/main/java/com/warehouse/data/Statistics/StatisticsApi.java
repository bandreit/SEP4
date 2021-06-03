package com.warehouse.data.Statistics;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StatisticsApi {
    @GET("sensorHistory/{sensorId}?period=2")
    Call<StatisticsResponse> getStatistics(@Path("sensorId") String sensorId, @Query("period") String period);
}
