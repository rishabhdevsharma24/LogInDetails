package com.example.logindetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn1,btn4;
boolean bhalusleeping=true;
    public  void Login(View view){
        EditText userNameEditText=(EditText)findViewById(R.id.userNameEditText);
        EditText editTextTextPassword=(EditText)findViewById(R.id.editTextTextPassword);
        Log.i("info","Button Pressed");
        Log.i("UserName",userNameEditText.getText().toString());
        Log.i("Password",editTextTextPassword.getText().toString());
        Toast.makeText(this,"Logged In Successfully", Toast.LENGTH_SHORT).show();

    }

    public void fade(View view){
        Log.i("info","Image View tapped");
        ImageView imageView=findViewById(R.id.imageView);
        ImageView ultimateView=findViewById(R.id.ultimateView);
        if(bhalusleeping){
            bhalusleeping=false;

            imageView.animate().alpha(0).setDuration(2000);
            ultimateView.animate().alpha(1).setDuration(2000);
        }
        else{
            bhalusleeping=true;
            imageView.animate().alpha(1).setDuration(2000);
            ultimateView.animate().alpha(0).setDuration(2000);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.button2);
        Toast.makeText(this,"MainActivity: onCreate()", Toast.LENGTH_SHORT).show();
        btn1.setOnClickListener((v -> {
            Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);
        }));
        btn4=(Button)findViewById(R.id.gridView);
        Toast.makeText(this,"MainActivity: onCreate()", Toast.LENGTH_SHORT).show();
        btn4.setOnClickListener((v -> {
            Intent intent=new Intent(MainActivity.this,GridView.class);
            startActivity(intent);
        }));
    }
}