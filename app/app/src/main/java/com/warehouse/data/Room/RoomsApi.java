package com.warehouse.data.Room;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RoomsApi {
    // /rooms
    @GET("ca62039e-e176-4047-b57f-64ed8b4d8ba8")
    Call<RoomsResponse> getRooms();
    // /sensors/:sensorId
    @PUT("/sensors/{id}")
    Call<RoomsResponse> updateSensor(@Path("id") String id, @Query("min") String min, @Query("max") String max);
}
