package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.example.trivia.databinding.ActivityCricketerBinding;
import com.example.trivia.databinding.ActivityMainBinding;

public class CricketerActivity extends AppCompatActivity {
private ActivityCricketerBinding binding;
    private static final String TAG = CricketerActivity.class.getName();
    private SharedPreferences sharedpreferences;
    private static String cricketer;
    private RadioButton radiobtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityCricketerBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Trivia App");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        cricketer="";
       binding.nextbtnn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int selectedId = binding.radiogrp.getCheckedRadioButtonId();
               // find the radiobutton by returned id
               radiobtn = (RadioButton) findViewById(selectedId);
               //getting the clicked radiobutton and storign value into shared preference
               if(binding.radiogrp.getCheckedRadioButtonId()!=-1){
                   cricketer=radiobtn.getText().toString();
               }
               sharedpreferences = getSharedPreferences("mypref", Context.MODE_PRIVATE);
               SharedPreferences.Editor editor=sharedpreferences.edit();
               editor.putString("cricketer",cricketer);
               editor.apply();
               Log.d(TAG, "Cricketerrrrrrr  "+cricketer);
               if(binding.radiogrp.getCheckedRadioButtonId()!=-1){
                   Intent intent=new Intent(CricketerActivity.this,FlagcolorActivity.class);
                   startActivity(intent);
                   finish();
               }
           }
       });

    }
}