package com.example.planegameclient;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.example.planegameclient.thread.NetworkThread;

public class MainActivity extends AppCompatActivity {


    public Bitmap planeRed;
    public Bitmap planeYellow;
    public NetworkThread nt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        planeRed = BitmapFactory.decodeResource(getResources(),R.drawable.red);
        planeYellow = BitmapFactory.decodeResource(getResources(),R.drawable.yellow);

        nt = new NetworkThread(MainActivity.this);
        nt.start();
    }
}