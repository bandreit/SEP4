package com.warehouse.data.Room;

import android.content.Context;

import androidx.room.Database;


@Database(entities = {Room.class}, version = 1)
public abstract class RoomsDatabase extends androidx.room.RoomDatabase {
    private static RoomsDatabase instance;
    public abstract RoomsDao roomsDao();

    public static synchronized RoomsDatabase getInstance(Context context) {
        if(instance == null) {
            instance = androidx.room.Room.databaseBuilder(context.getApplicationContext(),
                    RoomsDatabase.class, "rooms_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }
}
