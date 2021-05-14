package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.trivia.dao.Historydao;
import com.example.trivia.database.HstryRommdatabase;
import com.example.trivia.databinding.ActivityFlagcolorBinding;
import com.example.trivia.databinding.ActivitySummaryBinding;
import com.example.trivia.repository.HistryRepository;
import com.example.trivia.viewmodel.GameHistory;
import com.example.trivia.viewmodel.HistViewmodel;

import java.util.ArrayList;
import java.util.List;

public class SummaryActivity extends AppCompatActivity {
    private ActivitySummaryBinding binding;
    private static final String TAG = SummaryActivity.class.getName();
    private SharedPreferences sharedpreferences;
    private String name,cricketer,flagcolor;
    HistViewmodel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivitySummaryBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Trivia App");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //get model view
        model=new ViewModelProvider(this).get(HistViewmodel.class);

        sharedpreferences = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        name=sharedpreferences.getString("username","");
        binding.name.setText("Hello "+name);
        cricketer=sharedpreferences.getString("cricketer","");
        binding.cricket.setText("Answer:  "+cricketer);
        flagcolor=sharedpreferences.getString("flagcolor","");
        binding.color.setText("Answer:  "+flagcolor.replaceAll(",$",""));

        binding.finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //inserting into room data
                GameHistory hist=new GameHistory(name,cricketer,flagcolor.replaceAll(",$",""));
                model.insert(hist);
                //Toast.makeText(SummaryActivity.this,"insertion is successfull",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(SummaryActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}