package com.example.logindetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GridView extends AppCompatActivity {


    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btnDownload,btn9,btn10,btn11,btn12,btn13,btn14;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

                btn7=(Button)findViewById(R.id.CountDownTextView);
        Toast.makeText(this,"MainActivity: onCreate()", Toast.LENGTH_SHORT).show();
        btn7.setOnClickListener((v -> {
            Intent intent=new Intent(GridView.this,CountDown.class);
            startActivity(intent);
        }));
        btn1=(Button)findViewById(R.id.Sinchan);
        Toast.makeText(this,"MainActivity: onCreate()", Toast.LENGTH_SHORT).show();
        btn1.setOnClickListener((v -> {
            Intent intent=new Intent(GridView.this,DownloadTask.class);
            startActivity(intent);
        }));
        btn3=(Button)findViewById(R.id.PlayGame);
        Toast.makeText(this,"MainActivity: onCreate()", Toast.LENGTH_SHORT).show();
        btn3.setOnClickListener((v -> {
            Intent intent=new Intent(GridView.this,BoardGame.class);
            startActivity(intent);
        }));
        btn4=(Button)findViewById(R.id.SignUp);
        Toast.makeText(this,"MainActivity: onCreate()", Toast.LENGTH_SHORT).show();
        btn4.setOnClickListener((v -> {
            Intent intent=new Intent(GridView.this,SignUpActivity.class);
            startActivity(intent);
        }));
        btn2=(Button)findViewById(R.id.music);
        Toast.makeText(this,"MainActivity: onCreate()", Toast.LENGTH_SHORT).show();
        btn2.setOnClickListener((v -> {
            Intent intent=new Intent(GridView.this,Music.class);
            startActivity(intent);
        }));
        btn6=(Button)findViewById(R.id.ListsViews);
        Toast.makeText(this,"MainActivity: on Create()",Toast.LENGTH_SHORT).show();
        btn6.setOnClickListener((v -> {
            Intent intent=new Intent(GridView.this,FriendView.class);
            startActivity(intent);
        }));
        btn5=(Button)findViewById(R.id.Sleep);
        Toast.makeText(this,"MainActivity: on Create()",Toast.LENGTH_SHORT).show();
        btn5.setOnClickListener((v -> {
            Intent intent=new Intent(GridView.this,Sleep.class);
            startActivity(intent);
        }));
        btnDownload=(Button)findViewById(R.id.TimeTable);
        Toast.makeText(this,"MainActivity: on Create()",Toast.LENGTH_SHORT).show();
        btnDownload.setOnClickListener((v -> {
            Intent intent=new Intent(GridView.this,TimeTable.class);
            startActivity(intent);
        }));
        btn8=(Button)findViewById(R.id.Celibrity);
        Toast.makeText(this,"MainActivity: on Create()",Toast.LENGTH_SHORT).show();
        btn8.setOnClickListener((v -> {
            Intent intent=new Intent(GridView.this,Celibrity.class);
            startActivity(intent);
        }));
        btn9=(Button)findViewById(R.id.Weather);
        Toast.makeText(this,"MainActivity: on Create()",Toast.LENGTH_SHORT).show();
        btn9.setOnClickListener((v -> {
            Intent intent=new Intent(GridView.this,WeatherApp.class);
            startActivity(intent);
        }));
        btn10=(Button)findViewById(R.id.map);
        Toast.makeText(this,"MainActivity: on Create()",Toast.LENGTH_SHORT).show();
        btn10.setOnClickListener((v -> {
            Intent intent=new Intent(GridView.this,MapsActivity.class);
            startActivity(intent);
        }));
        btn11=(Button)findViewById(R.id.Update);
        Toast.makeText(this,"MainActivity: on Create()",Toast.LENGTH_SHORT).show();
        btn11.setOnClickListener((v -> {
            Intent intent=new Intent(GridView.this,UserLocation.class);
            startActivity(intent);
        }));
        btn12=(Button)findViewById(R.id.HW);
        Toast.makeText(this,"MainActivity: on Create()",Toast.LENGTH_SHORT).show();
        btn12.setOnClickListener((v -> {
            Intent intent=new Intent(GridView.this,HikersWatch.class);
            startActivity(intent);
        }));
        btn13=(Button)findViewById(R.id.Second);
        Toast.makeText(this,"MainActivity: on Create()",Toast.LENGTH_SHORT).show();
        btn13.setOnClickListener((v -> {
            Intent intent=new Intent(GridView.this,Shared.class);
            startActivity(intent);
        }));
        btn14=(Button)findViewById(R.id.Calci);
        Toast.makeText(this,"MainActivity: on Create()",Toast.LENGTH_SHORT).show();
        btn14.setOnClickListener((v -> {
            Intent intent=new Intent(GridView.this,DataStoring.class);
            startActivity(intent);
        }));
    }
}