package com.fengniao.materialtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class CircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        Log.i("mycolors", Math.sin(1 / 6 * Math.PI) + "");
        Log.i("mycolors", Math.sin(0) + "");
    }
}
