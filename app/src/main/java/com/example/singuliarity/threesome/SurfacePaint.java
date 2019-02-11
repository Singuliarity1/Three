package com.example.singuliarity.threesome;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfacePaint extends SurfaceView implements SurfaceHolder.Callback {

    SurfaceHolder sh;
    ThreadScreen th;
    Context ctx;
    SurfacePaint(Context ctx){
        super(ctx);
        getHolder().addCallback(this);
        this.ctx=ctx;

    }

    public void setElementCoords(int x,int y){
        th.setElementCoords(x,y);
    }

    public void setMoveElementCoords(int x,int y){
        th.setMoveElementCoords(x,y);
    }


    public void setUpElementCoords(int x,int y){
        th.setUpElementCoords(x,y);
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        th=new ThreadScreen(holder,ctx);
        th.run(true);
        th.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean stop=true;
        th.run(false);
        while(stop){
            try{
                th.join();
                stop=false;
            }catch(InterruptedException e){}
        }
    }
}
