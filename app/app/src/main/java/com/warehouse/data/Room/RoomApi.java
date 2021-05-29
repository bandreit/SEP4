package com.warehouse.data.Room;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RoomApi {
    // /rooms
    @GET("fed032ca-d872-40fd-8827-a2390b90515b")
    Call<RoomsResponse> getRooms();
}
