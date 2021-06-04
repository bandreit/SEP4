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
    private static StatisticsRepository instance;
    private MutableLiveData<List<Statistics>> statistics;

    private StatisticsRepository(Application application) {
        statistics = new MutableLiveData<>();
    }

    public static synchronized StatisticsRepository getInstance(Application application) {
        if (instance == null) {
            instance = new StatisticsRepository(application);
        }

        return instance;
    }

    public LiveData<List<Statistics>> getStatistics() {
        return statistics;
    }

    public void insert(List<Statistics> statistics) {
        this.statistics.postValue(statistics);
    }

    public void fetchStatistics(String roomId, String period) {
        Call<StatisticsResponse> call = statisticsApi.getStatistics(roomId, period);

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
