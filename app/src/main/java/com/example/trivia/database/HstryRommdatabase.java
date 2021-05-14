package com.example.trivia.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.trivia.dao.Historydao;
import com.example.trivia.viewmodel.GameHistory;

@Database(entities = {GameHistory.class},version = 5,exportSchema = false)
public abstract class HstryRommdatabase extends RoomDatabase {
    private static final String Database_Name="HstryRommdatabase";
    private static volatile HstryRommdatabase INSTANCE;
    private static Context activity;
    public abstract Historydao gethistdao();
public static HstryRommdatabase getInstance(Context context){
    activity=context.getApplicationContext();
    if(INSTANCE==null){
        synchronized (HstryRommdatabase.class){
            if(INSTANCE==null){
                INSTANCE= Room.databaseBuilder(context,HstryRommdatabase.class,Database_Name)
                        .build();
            }
        }
    }
    return INSTANCE;
}
static Callback callback=new Callback() {
    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        super.onCreate(db);
        new Papulate(INSTANCE).execute();
    }
};
    private static class Papulate extends AsyncTask<Void,Void,Void> {
       private Historydao dao;
        Papulate( HstryRommdatabase db){
          dao=db.gethistdao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            //dao.delete();
            return null;
        }
    }

}
