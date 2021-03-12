package com.example.logindetails;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toast.makeText(this,"SignUpActivity: onCreate()", Toast.LENGTH_SHORT).show();

    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        Toast.makeText(this,"SignUpActivity: onStart()", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    public void onResume() {
//        super.onResume();
//        Toast.makeText(this,"SignUpActivity: onResume()", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    public void onPause() {
//        super.onPause();
//        Toast.makeText(this,"SignUpActivity: onPause()", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    public void onStop() {
//        super.onStop();
//        Toast.makeText(this,"SignUpActivity: onStop()", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    public void onRestart() {
//        super.onRestart();
//        Toast.makeText(this,"SignUpActivity: onRestart()", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(this,"SignUpActivity: onDestroy()", Toast.LENGTH_SHORT).show();
//    }



        public  void Renders(View view) {
           ImageButton btn1 = (ImageButton) findViewById(R.id.imageButton);
            Toast.makeText(this,"MainActivity: onCreate()", Toast.LENGTH_SHORT).show();
            btn1.setOnClickListener((v -> {
                Intent intent=new Intent(SignUpActivity.this,Sleep.class);
                startActivity(intent);
            }));
        }


    }
