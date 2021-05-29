package com.warehouse.ui.dashboard;

import android.app.Application;
import android.os.Build;
import android.telecom.Call;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.warehouse.data.Room.Room;
import com.warehouse.data.Room.Statistics;
import com.warehouse.data.Room.StatisticsRepository;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class DashboardViewModel extends AndroidViewModel {
    private StatisticsRepository statisticsRepository;

    public DashboardViewModel(@NonNull Application application) {
        super (application);

        statisticsRepository = StatisticsRepository.getInstance (application);
    }

    public void init(){
        statisticsRepository.fetchStatistics ();
    }

    private LiveData<List<Statistics>> getStatistics() {
        return statisticsRepository.getStatistics ();
    }

    public HashMap<Integer, Integer> getActivity() {
        HashMap<Integer, Integer> activity = new HashMap<Integer, Integer>();


        List<Statistics> statistics = getStatistics ().getValue ();
        List<Integer> days = Arrays.asList(
                Calendar.SUNDAY,
                Calendar.MONDAY,
                Calendar.TUESDAY,
                Calendar.WEDNESDAY,
                Calendar.THURSDAY,
                Calendar.FRIDAY,
                Calendar.SATURDAY
        );

        for(int i = 0; i <= days.size () - 1; i++) {
            activity.put(days.get (i), 0);
        }

        for (Statistics values : Objects.requireNonNull (statistics)) {
            if(values.getName ().equals ("temperature")) {
                for (int i = 0; i <= values.getValues ().size () - 1 ; i++) {
                    activity.put (days.get (i), values.getValues ( ).get (i));
                }
            }
        }
        return activity;
    }
}
