package com.warehouse.data.Room;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RoomsApi {
    // /rooms
    @GET("rooms")
    Call<RoomsResponse> getRooms();

    @PUT("sensor/{sensorId}")
    Call<RoomsResponse> updateSensor(@Path("sensorId") String id, @Query("min") String min, @Query("max") String max);
}
