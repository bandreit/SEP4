package com.warehouse.data.Room;


import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.warehouse.services.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomRepository {
    private static RoomApi roomApi = ServiceGenerator.getRoomApi();
    private static RoomRepository instance;
    private final MutableLiveData<List<Room>> rooms;

    private RoomRepository() {
        this.rooms = new MutableLiveData<>();
    }

    public static synchronized RoomRepository getInstance(Application application) {
        if(instance == null) {
            instance = new RoomRepository();
        }

        return instance;
    }

    public LiveData<List<Room>> getRooms() {
        return rooms;
    }

    public void fetchRooms() {
        Call<RoomsResponse> call = roomApi.getRooms();

        call.enqueue(new Callback<RoomsResponse>() {
            @Override
            public void onResponse(Call<RoomsResponse> call, Response<RoomsResponse> response) {
                if(response.isSuccessful()) {
                    System.out.println("====== Success");
                } else {
                    System.out.println("Failure ======");

                    System.out.println(response.message());
                }
            }

            @Override
            public void onFailure(Call<RoomsResponse> call, Throwable t) {
                System.out.println("!!! Failure");

                t.printStackTrace();
            }
        });
    }
}
