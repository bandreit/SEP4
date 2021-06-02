package com.warehouse.data.Room;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RoomApi {
    // /rooms
    @GET("fed032ca-d872-40fd-8827-a2390b90515b")
    Call<RoomsResponse> getRooms();
    // /sensors/:sensorId
    @PUT("/sensors/{id}")
    Call<RoomsResponse> putSensor(@Path("id") String id, @Body Sensor sensor);
}
