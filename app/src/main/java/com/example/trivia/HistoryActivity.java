package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.trivia.adapter.HistAdapter;
import com.example.trivia.databinding.ActivityHistoryBinding;
import com.example.trivia.viewmodel.GameHistory;
import com.example.trivia.viewmodel.HistViewmodel;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
private ActivityHistoryBinding binding;
private HistViewmodel model;
    private SharedPreferences sharedpreferences;
    private List<GameHistory> list;
    private static final String TAG = HistoryActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityHistoryBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Trivia App");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        sharedpreferences = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        String date=sharedpreferences.getString("date","");
        list=new ArrayList<>();
        //set adapter
        binding.review.setLayoutManager(new LinearLayoutManager(this));
        binding.review.setHasFixedSize(true);
        HistAdapter adapter=new HistAdapter(this,list,date);
        binding.review.setAdapter(adapter);

        //set observer
       model=new ViewModelProvider(this).get(HistViewmodel.class);
       model.gethistry().observe(this, new Observer<List<GameHistory>>() {
           @Override
           public void onChanged(List<GameHistory> list) {
           adapter.getupdate(list);
           }
       });

    }
}