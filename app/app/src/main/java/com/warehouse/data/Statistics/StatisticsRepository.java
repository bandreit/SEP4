package com.warehouse.data.Statistics;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.warehouse.data.Room.Room;
import com.warehouse.data.Room.RoomRepository;
import com.warehouse.data.Room.RoomsApi;
import com.warehouse.data.Room.RoomsDao;
import com.warehouse.data.Room.RoomsDatabase;
import com.warehouse.services.ServiceGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatisticsRepository {
    private static StatisticsApi statisticsApi = ServiceGenerator.getStatisticsApi();
    private StatisticsDao statisticsDao;
    private static StatisticsRepository instance;
    private final ExecutorService executorService;
    private String roomId;
    private LiveData<List<Statistics>> statistics;

    private StatisticsRepository(Application application, String roomId) {
        this.roomId = roomId;

        StatisticsDatabase statisticsDatabase = StatisticsDatabase.getInstance(application);
        statisticsDao = statisticsDatabase.statisticsDao();
        executorService = Executors.newFixedThreadPool(2);
        statistics = statisticsDao.getAllStatistics();

    }

    public static synchronized StatisticsRepository getInstance(Application application, String roomId) {
        if (instance == null) {
            instance = new StatisticsRepository(application, roomId);
        }

        return instance;
    }

    public LiveData<List<Statistics>> getStatistics() {
        return statistics;
    }

    public void insert(List<Statistics> statistics) {
        executorService.execute(() -> statisticsDao.insert(statistics));
    }

    public void fetchStatistics() {
        Call<StatisticsResponse> call = statisticsApi.getStatistics();

        call.enqueue(new Callback<StatisticsResponse>() {
            @Override
            public void onResponse(Call<StatisticsResponse> call, Response<StatisticsResponse> response) {
                if (response.isSuccessful()) {
                    insert(response.body().getData());
                } else {
                    System.out.println("Failure ======");
                    System.out.println(response.message());
                }
            }

            @Override
            public void onFailure(Call<StatisticsResponse> call, Throwable t) {
                System.out.println("!!! Failure");
                t.printStackTrace();
            }
        });
    }
}
