package com.example.singuliarity.threesome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class StartActivity extends AppCompatActivity implements View.OnTouchListener {
    SurfacePaint sp;
    int x,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp=new SurfacePaint(this);
        setContentView(sp);
        sp.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = (int) event.getX();
        y = (int) event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("ACTION_DOWN",String.valueOf(x));
                sp.setElementCoords(x,y);

                break;
            case MotionEvent.ACTION_MOVE:
                sp.setMoveElementCoords(x,y);

                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
               
                sp.setUpElementCoords(x,y);
                break;
        }
        return true;
    }
}
