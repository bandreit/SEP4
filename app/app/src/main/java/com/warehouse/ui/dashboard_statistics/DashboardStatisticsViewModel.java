package com.warehouse.ui.dashboard_statistics;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.warehouse.data.Statistics.Statistics;
import com.warehouse.data.Statistics.StatisticsRepository;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class DashboardStatisticsViewModel extends AndroidViewModel {
    private StatisticsRepository statisticsRepository;

    public DashboardStatisticsViewModel(@NonNull Application application) {
        super(application);

        statisticsRepository = StatisticsRepository.getInstance(application);
    }

    public void init(String roomId) {
        statisticsRepository.fetchStatistics(roomId);
    }

    public LiveData<List<Statistics>> getStatistics() {
        return statisticsRepository.getStatistics();
    }

    public HashMap<Integer, Integer> getActivity(String name) {
        HashMap<Integer, Integer> activity = new HashMap<Integer, Integer>();

        List<Statistics> statistics = getStatistics().getValue();


        List<Integer> days = Arrays.asList(
                Calendar.SUNDAY,
                Calendar.MONDAY,
                Calendar.TUESDAY,
                Calendar.WEDNESDAY,
                Calendar.THURSDAY,
                Calendar.FRIDAY,
                Calendar.SATURDAY
        );

        for (int i = 0; i <= days.size() - 1; i++) {
            activity.put(days.get(i), 0);
        }

        for (Statistics values : Objects.requireNonNull(statistics)) {
            if (values.getName().equals(name)) {
                for (int i = 0; i <= values.getValues().size() - 1; i++) {
                    activity.put(days.get(i), values.getValues().get(i));
                }
            }
        }

        return activity;
    }

    public Float getAverageActivity(String name){
        float sum = 0;
        float average = 0;

        List<Statistics> statistics = getStatistics ().getValue ();
        for (Statistics values : Objects.requireNonNull (statistics)) {
            if(values.getName ().equals (name)){
                for (int i = 0; i <values.getValues ().size () ; i++) {
                    sum += values.getValues ().get (i);
                }
                average = sum / values.getValues ().size ();
            }
        }

        return average;
    }
}