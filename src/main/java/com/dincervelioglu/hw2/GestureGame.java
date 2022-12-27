package com.dincervelioglu.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.gesture.Gesture;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.Toast;

public class GestureGame extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private static final String TAG = "Swipe Position";
    private float x1, x2, yl, y2;
    private static int MIN_DISTANCE = 150;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hiding title bar using code
        getSupportActionBar().hide();
        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //initialize gesturedetector
        this.gestureDetector = new GestureDetector( GestureGame.this, this);
    }

    @Override
    public boolean onTouchEvent (MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        switch (event.getAction()) {
            //starting to swipe time gesture
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                yl = event.getY();
                break;
                //ending time swipe gesture
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();
                //getting value for horizontal swipe
                float valueX = x2 - x1;
                //getting value for vertical swipe
                float valueY = y2 - yl;

                if (Math.abs(valueX) > MIN_DISTANCE)
                {
                    //detect left to right swipe
                    if (x2>x1)
                    {
                        Toast.makeText( this, "Right is swiped", Toast.LENGTH_SHORT).show();
                        Log.d(TAG,"Right Swipe");
                    }
                    else
                    {
                    //detect right to left swipe
                        Toast.makeText( this, "Left is swiped", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Left Swipe");
                    }
                }
                else if (Math.abs (valueY) > MIN_DISTANCE) {
                    //detect top to bottom swipe
                    if (y2 > yl) {
                        Toast.makeText(this, "Bottom swipe", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Bot");
                    }
                    else
                    {
                    //detect bottom to top swipe
                        Toast.makeText( this, "Top swipe", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Top swipe");
                    }
                }
        }
        return super.onTouchEvent(event);
    }


    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}