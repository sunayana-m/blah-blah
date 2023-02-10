package com.example.a5_165;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int forwardTime = 5000;
    int rewindTime = 5000;
    TextView song_name;
    MediaPlayer mediaPlayer;
    Button play,pause,stop,rwnd,frwd,replay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=findViewById(R.id.bt1);
        pause=findViewById(R.id.bt2);
        stop=findViewById(R.id.bt5);
        rwnd=findViewById(R.id.bt4);
        frwd=findViewById(R.id.bt3);
        replay=findViewById(R.id.bt6);

        mediaPlayer=MediaPlayer.create(this,R.raw.song);
        song_name=findViewById(R.id.music);
        song_name.setText("Vaaste");
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "playing song", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "song paused", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "song stopped", Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
            }
        });
        frwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=mediaPlayer.getCurrentPosition();
                if((pos+forwardTime)<=mediaPlayer.getDuration()){
                    Toast.makeText(MainActivity.this, "Song forwarded", Toast.LENGTH_SHORT).show();
                    mediaPlayer.seekTo(pos+forwardTime);
                }
            }
        });
        rwnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=mediaPlayer.getCurrentPosition();
                if((pos-rewindTime)<=mediaPlayer.getDuration()){
                    Toast.makeText(MainActivity.this, "Song rewinded", Toast.LENGTH_SHORT).show();
                    mediaPlayer.seekTo(pos-rewindTime);
                }
            }
        });
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Song replaying", Toast.LENGTH_SHORT).show();
                mediaPlayer.seekTo(0);
            }
        });
    }
}