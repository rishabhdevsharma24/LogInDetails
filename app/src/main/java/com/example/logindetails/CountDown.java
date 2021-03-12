package com.example.logindetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class CountDown extends AppCompatActivity {

    TextView CountDownTextView;
    SeekBar TimerSeekBar;
    public void show(View view)
    {
        CountDownTextView.setVisibility(View.VISIBLE);
    }
    public void Hide(View view)
    {
        CountDownTextView.setVisibility(View.INVISIBLE);
    }
public void Reflex(View view){
        CountDownTextView.setVisibility(View.INVISIBLE);
}
    public void buttonClicked(View view){

        CountDownTimer CountDownTextView=new CountDownTimer(TimerSeekBar.getProgress()*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                updateTimer((int) millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

                Log.i("Finished","Timer All Done");
            }
        }.start();
    }
    public void updateTimer(int secondLeft)
    {
        int minutes=secondLeft/60;
        int seconds=secondLeft-(minutes*60);
        String secondString=Integer.toString(seconds);
        if(seconds<=9){
            secondString="0"+secondString;
        }
        CountDownTextView.setText(Integer.toString(minutes)+":"+secondString);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);

         TimerSeekBar=findViewById(R.id.TimerSeekBar);
         CountDownTextView=findViewById(R.id.CountDownTextView);
        TimerSeekBar.setMax(600);
        TimerSeekBar.setProgress(30);
        TimerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                updateTimer(i);
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


