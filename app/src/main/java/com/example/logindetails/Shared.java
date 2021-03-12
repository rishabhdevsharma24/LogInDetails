package com.example.logindetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class Shared extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);
        SharedPreferences sharedPreferences=this.getSharedPreferences("com.example.logindetails", Context.MODE_PRIVATE);
        ArrayList <String> Friends=new ArrayList<>();
        Friends.add("Neeraj Pandey");
        Friends.add("Rishabh");
        Friends.add("Amber");
        try {
            sharedPreferences.edit().putString("", ObjectSerializer.serialize(Friends)).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<String> newFriends=new ArrayList<>();
        try{
            newFriends=(ArrayList<String>)ObjectSerializer.deserialize(sharedPreferences.getString("Friends",ObjectSerializer.serialize(new ArrayList<String>())));

        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("new Friends",newFriends.toString());

           /* sharedPreferences.edit().putString("username","nick").apply();
            String username=sharedPreferences.getString("username","");
            Log.i("This is the UserName",username);
        Toast.makeText(Shared.this, username, Toast.LENGTH_SHORT).show();*/
    }
}