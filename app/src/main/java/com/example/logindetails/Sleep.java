package com.example.logindetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class Sleep extends AppCompatActivity {
    int randomNumber;
public void SwitchMode(View view)
{
    Log.i("Info","Button Pressed");
    ImageView image= findViewById(R.id.imageView2);
    image.setImageResource(R.drawable.bearbhalu);
}
public void fade(View view){
    Log.i("info","Image view Tapped");
    ImageView bartImageView=(ImageView)findViewById(R.id.imageView2);
    ImageView homerImageView=(ImageView)findViewById(R.id.imageView2);
    bartImageView.animate().rotation(1800).setDuration(2000);
}
public void guess(View view) {

    EditText editText=findViewById(R.id.guess);
    int guessValue=Integer.parseInt(editText.getText().toString());
    String message;
    if(guessValue>randomNumber)
    {
        message="Lower!";

    }else if(guessValue<randomNumber)
    {
        message="Higher!";

    }else
    {
        message="you Got the right Number Play Again";
        generateRandomNumber();
    }
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show();



}
public void generateRandomNumber(){
    Random rn = new Random();
    randomNumber = rn.nextInt(10) + 1;
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);
        generateRandomNumber();

    }
}