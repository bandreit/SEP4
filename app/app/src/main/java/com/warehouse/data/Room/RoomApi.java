package com.warehouse.data.Room;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RoomApi {
    // /rooms
    @GET("ca62039e-e176-4047-b57f-64ed8b4d8ba8")
    Call<RoomsResponse> getRooms();
}
