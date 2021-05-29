package com.warehouse.data.Room;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StatisticsApi {
    // /statistics/:roomId?period=7
    @GET("e38f2027-95f7-4232-b87f-bb5c1b455ece")
    Call<StatisticsResponse> getStatistics();
}
