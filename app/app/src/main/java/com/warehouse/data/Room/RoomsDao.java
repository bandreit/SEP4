package com.warehouse.data.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RoomsDao {
    @Insert
    void insert(Room room);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Room> rooms);

    @Query("SELECT * FROM rooms_table")
    LiveData<List<Room>> getAllRooms();

    @Query("DELETE FROM rooms_table")
    void deleteAllRooms();
}
