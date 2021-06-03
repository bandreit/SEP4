package com.warehouse.data.Statistics;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.warehouse.services.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatisticsRepository {
    private static StatisticsApi statisticsApi = ServiceGenerator.getStatisticsApi ();
    private static StatisticsRepository instance;
    private final MutableLiveData<List<Statistics>> statistics;

    private StatisticsRepository() {
        this.statistics = new MutableLiveData<> ();
    }

    public static synchronized StatisticsRepository getInstance(Application application) {
        if(instance == null) {
            instance = new StatisticsRepository ();
        }

        return instance;
    }

    public LiveData<List<Statistics>> getStatistics() {
        return statistics;
    }

    public void fetchStatistics(String roomId) {
        Call<StatisticsResponse> call = statisticsApi.getStatistics (roomId);

        call.enqueue(new Callback<StatisticsResponse>() {
            @Override
            public void onResponse(Call<StatisticsResponse> call, Response<StatisticsResponse> response) {
                if(response.isSuccessful()) {
                    statistics.postValue(response.body().getData());
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
