package com.warehouse.data.Statistics;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import java.util.List;

@Dao
public interface StatisticsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Statistics> statistics);

    @Query("SELECT * FROM statistics")
    LiveData<List<Statistics>> getAllStatistics();
}
