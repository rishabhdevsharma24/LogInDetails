package com.example.logindetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConsumingJSON extends AppCompatActivity {

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
                return result;
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        protected  void onPostExecute(String s){
            super.onPostExecute(s);
            Log.i("JSON",s);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consuming_j_s_o_n);
        DownloadTask task=new DownloadTask();
        task.execute("api.openweathermap.org/data/2.5/weather?q=London&appid=76e0f83d62d0cf723449a8f4ae8ffbcb");
    }
}