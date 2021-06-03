package com.warehouse.data.Room;


import android.app.Application;

import androidx.lifecycle.LiveData;

import com.warehouse.services.ServiceGenerator;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomRepository {
    private static RoomsApi roomsApi = ServiceGenerator.getRoomsApi();
    private RoomsDao roomsDao;
    private static RoomRepository instance;
    private LiveData<List<Room>> rooms;
    private final ExecutorService executorService;

    private RoomRepository(Application application) {
        RoomsDatabase roomsDatabase = RoomsDatabase.getInstance(application);
        roomsDao = roomsDatabase.roomsDao();
        rooms = roomsDao.getAllRooms();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static synchronized RoomRepository getInstance(Application application) {
        if (instance == null) {
            instance = new RoomRepository(application);
        }

        return instance;
    }

    public LiveData<List<Room>> getRooms() {
        return rooms;
    }

    public void insert(List<Room> rooms) {
        executorService.execute(() -> roomsDao.insert(rooms));
    }


    public void fetchRooms() {
        Call<RoomsResponse> call = roomsApi.getRooms();

        call.enqueue(new Callback<RoomsResponse>() {
            @Override
            public void onResponse(Call<RoomsResponse> call, Response<RoomsResponse> response) {
                if (response.isSuccessful()) {
                    insert(response.body().getData());
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

    public void updateSensor(String id, String minValue, String maxValue) {
        Call<RoomsResponse> call = roomsApi.updateSensor(id, minValue, maxValue);

        call.enqueue(new Callback<RoomsResponse>() {
            @Override
            public void onResponse(Call<RoomsResponse> call, Response<RoomsResponse> response) {
                if (response.isSuccessful()) {
                    fetchRooms();
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
