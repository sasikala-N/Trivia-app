package com.example.trivia.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.trivia.repository.HistryRepository;

import java.util.List;

public class HistViewmodel extends AndroidViewModel {
    private HistryRepository repo;
    private LiveData<List<GameHistory>>list;
    public HistViewmodel(@NonNull Application application) {
        super(application);
        repo=new HistryRepository(application);
    }
    public LiveData<List<GameHistory>>gethistry(){
    return repo.getlistt();
    }
    public void insert(GameHistory list){
        repo.insertlist(list);
    }
    public void delete(){
        repo.deletelist();
    }
}
