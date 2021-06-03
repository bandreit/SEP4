package com.warehouse.data.Room;

import android.os.AsyncTask;

import java.util.List;

public class InsertRoomsAsync extends AsyncTask<List<Room>, Void, Void> {
    private RoomsDao roomsDao;

    public InsertRoomsAsync(RoomsDao roomsDao) {
        this.roomsDao = roomsDao;
    }

    @Override
    protected Void doInBackground(List<Room>... lists) {
        roomsDao.insert(lists[0]);
        return null;
    }
}
