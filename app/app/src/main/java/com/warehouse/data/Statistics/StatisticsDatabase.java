package com.warehouse.data.Statistics;

import android.content.Context;

import androidx.room.Database;


@Database(entities = {Statistics.class}, version = 1)
public abstract class StatisticsDatabase extends androidx.room.RoomDatabase {
    private static StatisticsDatabase instance;
    public abstract StatisticsDao statisticsDao();

    public static synchronized StatisticsDatabase getInstance(Context context) {
        if(instance == null) {
            instance = androidx.room.Room.databaseBuilder(context.getApplicationContext(),
                    StatisticsDatabase.class, "statistics")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }
}
