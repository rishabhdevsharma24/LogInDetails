package com.example.logindetails;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Celibrity extends AppCompatActivity {

        ArrayList<String> celebURLs=new ArrayList<>();
        ArrayList<String>  celebNames=new ArrayList<>();
        int chosenCeleb=0, correctAnswerLocation;
        String[] answers=new String[4];
        private ImageView celebImageView;
        private Button option1, option2, option3, option4;

        public class ImageDownloader extends AsyncTask<String, Void, Bitmap>{
            @Override
            protected Bitmap doInBackground(String... urls) {
                try {
                    URL url=new URL(urls[0]);
                    HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                    connection.connect();
                    InputStream in = connection.getInputStream();
                    Bitmap myBitmap= BitmapFactory.decodeStream(in);
                    return myBitmap;
                }catch (Exception e){
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
            }
        }

        public class DownloadTask extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... urls) {
                String result="";
                URL url;
                HttpURLConnection urlConnection=null;

                try  {
                    url=new URL(urls[0]);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream in = urlConnection.getInputStream();
                    InputStreamReader reader=new InputStreamReader(in);

                    int data=reader.read();
                    while (data!=-1){
                        char current = (char) data;
                        result += current;
                        data=reader.read();
                    }
                    return result;
                }catch (Exception e){
                    e.printStackTrace();
                    return  null;
                }
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                newQuestion();
            }
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_celibrity);

            celebImageView=findViewById(R.id.celebImageView);
            option1=findViewById(R.id.option1);
            option2=findViewById(R.id.option2);
            option3=findViewById(R.id.option3);
            option4=findViewById(R.id.option4);

            DownloadTask task = new DownloadTask();
            String result;

            try {
                result = task.execute("https://web.archive.org/web/20190119082828/www.posh24.se/kandisar").get();
                String[] splitResult= result.split("<div class=\"listedArticals\">");
                Pattern p= Pattern.compile("img src=\"(.*?)\"");
                Matcher m=p.matcher((splitResult[0]));

                while(m.find()){
                    celebURLs.add(m.group(1));
                }
                p=Pattern.compile("alt=\"(.*?)\"");
                m=p.matcher(splitResult[0]);
                while (m.find()){
                    celebNames.add(m.group(1));
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        public void newQuestion(){
            try {
                Random rand = new Random();
                chosenCeleb = rand.nextInt(celebURLs.size());
                ImageDownloader imageTask = new ImageDownloader();
                Bitmap celebImage = imageTask.execute(celebURLs.get(chosenCeleb)).get();
                celebImageView.setImageBitmap(celebImage);
                correctAnswerLocation = rand.nextInt(4);
                int incorrectAnswerLocation;
                for (int i = 0; i < 4; i++) {
                    if (i == correctAnswerLocation) {
                        answers[i] = celebNames.get(chosenCeleb);
                    } else {
                        incorrectAnswerLocation = rand.nextInt(celebURLs.size());
                        while (incorrectAnswerLocation == chosenCeleb) {
                            incorrectAnswerLocation = rand.nextInt(celebURLs.size());
                        }
                        answers[i] = celebNames.get(incorrectAnswerLocation);
                    }
                }

                option1.setText((answers[0]));
                option2.setText((answers[1]));
                option3.setText((answers[2]));
                option4.setText((answers[3]));
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        public void selectAnswer(View view){
            if(view.getTag().toString().equals(Integer.toString(correctAnswerLocation))){
                Toast.makeText(Celibrity.this, "Correct", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(Celibrity.this, "Wrong! It was " +celebNames.get(chosenCeleb) , Toast.LENGTH_SHORT).show();
            }
            newQuestion();
        }
    }