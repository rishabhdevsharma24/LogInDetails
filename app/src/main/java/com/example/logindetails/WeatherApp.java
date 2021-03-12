package com.example.logindetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp extends AppCompatActivity {
    EditText editText;
    TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_app);
        editText=findViewById(R.id.editText);
        resultTextView=findViewById(R.id.resultTextView);

    }
    public  void  getWeather(View view)
    {
        DownloadTask task=new DownloadTask();


        task.execute("https://api.openweathermap.org/data/2.5/weather?q=London&appid=76e0f83d62d0cf723449a8f4ae8ffbcb");
    }

    public class DownloadTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            String result="";
            URL url;
            HttpURLConnection urlConnection=null;
            try{
                url=new URL(urls[0]);
                urlConnection=(HttpURLConnection) url.openConnection();
                InputStream in=urlConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(in);
                int data=reader.read();
                while(data !=-1){
                    char current=(char) data;
                    result +=current;
                    data=reader.read();
                }
                Log.i("result: ", result);
                return result;
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        protected  void onPostExecute(String s){
            super.onPostExecute(s);
            try{
                JSONObject jsonObject=new JSONObject(s);
                String weatherInfo=jsonObject.getString("restaurants");
                Log.i("Weather content",weatherInfo);
                JSONArray arr=new JSONArray(weatherInfo);
                String message="";
                for(int i=0;i<arr.length();i++)
                {
                    JSONObject jsonPart=arr.getJSONObject(i);
                    String main=jsonPart.getString("name");
                    String description =jsonPart.getString("type");
                    if(!main.equals("") && !description.equals(""))
                    {
                        message +=main +":" + description;
                    }
                }
                if (!message.equals("")) {
                    resultTextView.setText(message);
                    Log.i("content",message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}