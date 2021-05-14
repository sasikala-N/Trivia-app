package com.example.trivia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.trivia.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private ActivityMainBinding binding;
    SharedPreferences sharedpreferences;
    private static String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        //adding toolbar
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Trivia App");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");
        String currentDateandTime = sdf.format(new Date());
        username="";
        binding.nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getting user and stopring into sharedpreference
                username=binding.username.getText().toString();
                sharedpreferences = getSharedPreferences("mypref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedpreferences.edit();
                editor.putString("username",username);
                editor.putString("date",currentDateandTime);
                //hToast.makeText(MainActivity.this,currentDateandTime,Toast.LENGTH_SHORT).show();
                editor.apply();
                if(!binding.username.getText().toString().isEmpty()){
                    Intent intent=new Intent(MainActivity.this,CricketerActivity.class);
                    startActivity(intent);
                    finish();
                }
                Log.d(TAG, "usernameeeee       "+username);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //To history
        if(item.getItemId()==R.id.hstry)
        {
         startActivity(new Intent(MainActivity.this,HistoryActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertdialog = builder.create();
        alertdialog.show();
    }

}