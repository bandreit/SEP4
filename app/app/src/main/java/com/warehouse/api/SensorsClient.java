package com.warehouse.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SensorsClient {
    @GET("/parameters")
    Call<SensorsResponse> getParameters();
}
