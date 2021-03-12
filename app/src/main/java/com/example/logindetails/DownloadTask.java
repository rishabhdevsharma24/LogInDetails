package com.example.logindetails;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadTask extends AppCompatActivity {

//    public class DownloadTasks extends AsyncTask<String,Void,String> {
//
//
//        @Override
//        protected String doInBackground(String... urls) {
//            String result=" ";
//            URL url;
//            HttpURLConnection urlConnection=null;
//            try{
//                url=new URL((urls[0]));
//                urlConnection=(HttpURLConnection) url.openConnection();
//                InputStream in=urlConnection.getInputStream();
//                InputStreamReader reader=new InputStreamReader(in);
//                int data=reader.read();
//                while (data!=-1){
//                    char current=(char)data;
//                    result +=current;
//                    data=reader.read();
//                }
//                return  result;
//            } catch (Exception e) {
//                e.printStackTrace();
//                return "Failed";
//            }
//        }
//    }

    ImageView imageView;
    public void downloadImage(View view){
        ImageDownloader task=new ImageDownloader();
        Bitmap myImage;
        try {
            myImage=task.execute("https://wallpapercave.com/wp/wp1812462.jpg").get();
            imageView.setImageBitmap(myImage);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_task);
        imageView=findViewById(R.id.imageView);
    }
    public class ImageDownloader extends AsyncTask<String,Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {

            try{
                URL url = new URL((urls[0]));
                HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream in=connection.getInputStream();
                Bitmap myBitmap= BitmapFactory.decodeStream(in);
                return myBitmap;

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}