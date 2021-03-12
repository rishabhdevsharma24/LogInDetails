package com.example.logindetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class DataStoring extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storing);
        SharedPreferences sharedPreferences=this.getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username","Rishabh Dev").apply();
        String username= sharedPreferences.getString("username","no data found");
        Toast.makeText(this,username,Toast.LENGTH_LONG).show();
    }
}