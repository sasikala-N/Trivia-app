package com.example.trivia.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.trivia.viewmodel.GameHistory;

import java.util.List;

@Dao
public interface Historydao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(GameHistory history);

    @Query("select * from history")
    LiveData<List<GameHistory>> gethistory();

    @Query("delete from history")
    void delete();

}
