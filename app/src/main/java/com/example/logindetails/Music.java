package com.example.logindetails;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Music extends AppCompatActivity {
    MediaPlayer mediaPlayer;
public  void play(View view){
    mediaPlayer= MediaPlayer.create(this,R.raw.oth);
    mediaPlayer.start();
}
public void  pause(View view){
    mediaPlayer.pause();
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        VideoView videoView=(VideoView)findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+ getPackageName()+"/"+R.raw.omnamahshivay);
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

}
}