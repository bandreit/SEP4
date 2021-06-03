package com.warehouse.ui.dashboard_statistics;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.warehouse.data.Statistics.Statistics;
import com.warehouse.data.Statistics.StatisticsRepository;
import com.warehouse.data.Statistics.StatisticsValue;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class DashboardStatisticsViewModel extends AndroidViewModel {
    private StatisticsRepository statisticsRepository;
    private String roomId;

    public DashboardStatisticsViewModel(@NonNull Application application) {
        super(application);

        statisticsRepository = StatisticsRepository.getInstance(application, roomId);
    }

    public void init(String roomId) {
        this.roomId = roomId;
        statisticsRepository.fetchStatistics();
    }

    public LiveData<List<Statistics>> getStatistics() {
        return statisticsRepository.getStatistics();
    }

    public HashMap<String, Double> getActivity(String name) {
        HashMap<String, Double> activity = new HashMap<String, Double>();
        List<Statistics> statistics = getStatistics().getValue();

        for (Statistics statisticsValue : statistics) {
            if (statisticsValue.getName().equals(name.toUpperCase())) {
                for (StatisticsValue statisticsHistory : statisticsValue.getValues()) {
                    activity.put(statisticsHistory.getTimestamp(), statisticsHistory.getValue());
                }
            }
        }


        return activity;
    }

    public Float getAverageActivity(String name) {
        float sum = 0;
        float average = 0;

        List<Statistics> statistics = getStatistics().getValue();

        for (Statistics statisticsValue : statistics) {
            if (statisticsValue.getName().equals(name.toUpperCase())) {
                for (StatisticsValue statisticsHistory : statisticsValue.getValues()) {
                    sum += statisticsHistory.getValue();
                }

                if(statisticsValue.getValues().size() > 0) {
                    average = sum / statisticsValue.getValues().size();
                }
            }
        }

        return average;
    }
}