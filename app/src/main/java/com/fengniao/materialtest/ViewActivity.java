package com.fengniao.materialtest;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {
    MyViewGroup viewGroup;
    MyView myView;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        myView = (MyView) findViewById(R.id.myView);
        button1 = (Button) findViewById(R.id.btn_one);
        button2 = (Button) findViewById(R.id.btn_two);
        viewGroup = (MyViewGroup) findViewById(R.id.activity_view);

//        viewGroup.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_MOVE) {
//                    Log.i("event", "getx     x" + event.getX() + "       y" + event.getY());
//                    Log.i("event", "getRawx     x" + event.getRawX() + "       y" + event.getRawY());
////                    Log.i("view", "getx        x" + v.getX() + "     y" + v.getY());
////                    Log.i("view", "getpivox        x" + v.getPivotX() + "     y" + v.getPivotY());
////                    Log.i("view", "getRotationx        x" + v.getRotationX() + "     y" + v.getRotationY());
////                    Log.i("view", "getScalex        x" + v.getScaleX() + "     y" + v.getScaleY());
////                    Log.i("view", "getTranslatinox        x" + v.getTranslationX() + "     y" + v.getTranslationY());
//                }
//
//                return false;
//            }
//        });
//        viewGroup.setLongClickable(true);
//        viewGroup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ViewActivity.this, "onClick", Toast.LENGTH_SHORT).show();
//            }
//        });


//        viewGroup.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Toast.makeText(ViewActivity.this, "longOnClick", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });


    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("mycolors","activity         actionDown");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("mycolors","activity         actionMove");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("mycolors","activity         actionUp");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("mycolors", "activity         " + "onTouchEvent");
        return super.onTouchEvent(event);
    }
}
