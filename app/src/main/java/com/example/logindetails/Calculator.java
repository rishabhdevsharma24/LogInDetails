package com.example.logindetails;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class Calculator extends AppCompatActivity {
EditText etFirstValue,etSecondValue;
TextView tvAns;
Button add,sub,multiply,divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {

            etFirstValue=findViewById(R.id.etFirstValue);
            etSecondValue=findViewById(R.id.etSecondValue);

            tvAns=findViewById(R.id.tvAns);
            add =findViewById(R.id.etAddition);
            sub=findViewById(R.id.etSubtract);
            multiply=findViewById(R.id.etMultiply);
            divide=findViewById(R.id.etDivide);
        } catch (Exception e) {
            e.printStackTrace();
        }
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int firstValue,secondValue,ans;
                    firstValue=Integer.parseInt(etFirstValue.getText().toString());
                    secondValue=Integer.parseInt(etSecondValue.getText().toString());
                    ans=firstValue+secondValue;
                    tvAns.setText("ans is :"+ans);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }


            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstValue,secondValue,ans;
                firstValue=Integer.parseInt(etFirstValue.getText().toString());
                secondValue=Integer.parseInt(etSecondValue.getText().toString());
                ans=firstValue-secondValue;
                tvAns.setText("ans is :"+ans);

            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstValue,secondValue,ans;
                firstValue=Integer.parseInt(etFirstValue.getText().toString());
                secondValue=Integer.parseInt(etSecondValue.getText().toString());
                ans=firstValue*secondValue;
                tvAns.setText("ans is :"+ans);

            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstValue,secondValue,ans;
                firstValue=Integer.parseInt(etFirstValue.getText().toString());
                secondValue=Integer.parseInt(etSecondValue.getText().toString());
                ans=firstValue/secondValue;
                tvAns.setText("ans is :"+ans);

            }
        });

    }
}

