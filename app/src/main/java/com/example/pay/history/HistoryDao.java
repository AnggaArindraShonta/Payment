package com.example.pay.history;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistoryDao {

    @Insert
    void insert(History history);

    @Delete
    void delete(History history);

    @Query("SELECT * FROM history_table ORDER BY namapembayaran ASC")
    LiveData<List<History>> getAllHistory();
}
