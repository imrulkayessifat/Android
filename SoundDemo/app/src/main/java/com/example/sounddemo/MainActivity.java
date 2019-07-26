package com.example.sounddemo;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mplayer;

    AudioManager audioManager;

    public void playAudio(View view){

        mplayer.start();
    }
    public void pauseAudio(View view){

        mplayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mplayer = MediaPlayer.create(this,R.raw.devil);

        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        int curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar volumeControl = (SeekBar) findViewById(R.id.seekBar);

        volumeControl.setMax(maxVolume);

        volumeControl.setProgress(curVolume);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            public void onStartTrackingTouch(SeekBar seekBar){

            }
            public void onStopTrackingTouch(SeekBar seekBar){

            }
            public void onProgressChanged(SeekBar seekBar,int progress,boolean fromUser){

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }
        });
        final SeekBar scrubber = (SeekBar) findViewById(R.id.scrubber);
        scrubber.setMax(mplayer.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask(){
            public void run(){
                scrubber.setProgress(mplayer.getCurrentPosition());
            }
        },0,1000);
        scrubber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            public void onStartTrackingTouch(SeekBar seekBar){

            }
            public void onStopTrackingTouch(SeekBar seekBar){

            }
            public void onProgressChanged(SeekBar seekBar,int progress,boolean fromUser){
                mplayer.seekTo(progress);
            }
        });
    }
}
