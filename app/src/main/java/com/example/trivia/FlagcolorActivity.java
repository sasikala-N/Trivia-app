package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.trivia.databinding.ActivityCricketerBinding;
import com.example.trivia.databinding.ActivityFlagcolorBinding;

public class FlagcolorActivity extends AppCompatActivity {
    private ActivityFlagcolorBinding binding;
    private static final String TAG = FlagcolorActivity.class.getName();
    private SharedPreferences sharedpreferences;
    private String flagcolor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding= ActivityFlagcolorBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Trivia App");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        flagcolor="";
        binding.flagnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //getting checked options and storing them in shared preference
                StringBuilder result=new StringBuilder();
                if(binding.white.isChecked()){
                    result.append("White,");
                }
                if(binding.green.isChecked()){
                    result.append("Green,");
                }
                if(binding.orange.isChecked()){
                    result.append("Orange,");
                }
                if(binding.yellow.isChecked()){
                    result.append("Yellow,");
                }

                flagcolor=result.toString();
                Log.d(TAG, "flagcolorrrrrr "+flagcolor);
                sharedpreferences = getSharedPreferences("mypref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedpreferences.edit();
                editor.putString("flagcolor",flagcolor);
                editor.apply();
//                Toast.makeText(getApplicationContext(), flagcolor, Toast.LENGTH_LONG).show();
                if(binding.green.isChecked()||binding.orange.isChecked()||binding.yellow.isChecked()||binding.white.isChecked()){
                    Intent intent=new Intent(FlagcolorActivity.this,SummaryActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}