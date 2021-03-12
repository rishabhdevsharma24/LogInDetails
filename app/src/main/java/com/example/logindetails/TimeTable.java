package com.example.logindetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class TimeTable extends AppCompatActivity {
    ListView timesTableListView;
    public void generateTimeTable(int timeTableNumber)
    {

        ArrayList<String> timeTableContent=new ArrayList<String>();
        for(int j=1;j<=10;j++)
        {
            timeTableContent.add(Integer.toString(j*timeTableNumber));

        }
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timeTableContent);
        timesTableListView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
       final  SeekBar timesTableSeekBar=findViewById(R.id.timesTableSeekBar);
         timesTableListView=findViewById(R.id.timesTableListView);
        int max=20;
        int startingPosition=10;
        timesTableSeekBar.setMax(max);
        timesTableSeekBar.setProgress(startingPosition);
        generateTimeTable(startingPosition);
        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                int min=1;
                int timeTableNumber;
                if(i<min){
                     timeTableNumber=min;
                }else {
                    timeTableNumber=i;
                }
                Log.i("SeekBar",Integer.toString(timeTableNumber));
                generateTimeTable(timeTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}