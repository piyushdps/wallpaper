package com.example.wallpaperapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnChangeWallpaper;
    boolean running;
    int[] imagesArray=new int[]{R.drawable.wal1,
            R.drawable.wal2,
            R.drawable.wal3,R.drawable.wal4,R.drawable.wal5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChangeWallpaper=(Button)
                findViewById(R.id.buttonchange);
        btnChangeWallpaper.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        if(!running)
        {
            new Timer().schedule
                    (new MyTimer(),30000,30000);
            running=true;
        }
    }
    class MyTimer extends TimerTask
    {
        public void run()
        {
            int aryLength = imagesArray.length;
            Random random = new Random();
            int rNum = random.nextInt(aryLength);
            try {
                WallpaperManager wallpaperManager =
                        WallpaperManager.getInstance(getBaseContext());
                wallpaperManager.setBitmap
                        (BitmapFactory.decodeResource(getResources(),
                                imagesArray[rNum]));

            }
            catch(Exception e)
            {
            }
        }
    }
}