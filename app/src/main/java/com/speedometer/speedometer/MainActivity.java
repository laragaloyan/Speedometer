package com.speedometer.speedometer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onStart(){
        super.onStart();
        final Speedometer speedometer = (Speedometer) findViewById(R.id.Speedometer);
        Button increaseSpeed = (Button) findViewById(R.id.IncreaseSpeed);
        Button decreaseSpeed = (Button) findViewById(R.id.DecreaseSpeed);
        increaseSpeed.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v,MotionEvent event) {
                return speedometer.onSpeedChanged(speedometer.getCurrentSpeed()+2);
            }

        });
        decreaseSpeed.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v,MotionEvent event) {
                return speedometer.onSpeedChanged(speedometer.getCurrentSpeed()-2);
            }
        });
    }
}