package com.example.trivia.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.trivia.dao.Historydao;
import com.example.trivia.database.HstryRommdatabase;
import com.example.trivia.viewmodel.GameHistory;

import java.util.List;

public class HistryRepository {
    private HstryRommdatabase db;
    Historydao dao;
    private LiveData<List<GameHistory>>list;
      public HistryRepository(Application application){
      db=HstryRommdatabase.getInstance(application);
      dao=db.gethistdao();
     }
public LiveData<List<GameHistory>>getlistt()
{
    list=dao.gethistory();
          return list;
}
public void insertlist(GameHistory history){
new Insertlist().execute(history);
}
public void deletelist(){
new Deletelist(db);
}
class Insertlist extends AsyncTask<GameHistory,Void,Void>{
    @Override
    protected Void doInBackground(GameHistory... gameHistories) {
      dao.insert(gameHistories[0]);
        return null;
    }
}
class Deletelist extends AsyncTask<Void,Void,Void>{
          Historydao dao;
          Deletelist(HstryRommdatabase db){
              dao=db.gethistdao();
          }

    @Override
    protected Void doInBackground(Void... voids) {
              dao.delete();
        return null;
    }
}
}
