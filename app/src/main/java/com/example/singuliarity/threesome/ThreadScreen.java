package com.example.singuliarity.threesome;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;

public class ThreadScreen extends Thread {
    SurfaceHolder sh;
    boolean run = false;
    GenerateScreen gs;
    Paint pcanvas;
    int xTap,yTap;
    int xUp,yUp;
    boolean up=false;

    ThreadScreen(SurfaceHolder sh,Context ctx) {
        this.sh = sh;
        pcanvas=new Paint();
        pcanvas.setStyle(Paint.Style.FILL);
        pcanvas.setColor(Color.WHITE);
        gs = new GenerateScreen(5,ctx);
    }

    public void setElementCoords(int x,int y){
        xTap=x;
        yTap=y;
    }

    public void setMoveElementCoords(int x,int y){

    }


    public void setUpElementCoords(int x,int y){
        xUp=x;
        yUp=y;
        up=true;

    }


    void run(boolean run) {
        this.run = run;
    }

    @Override
    public void run() {
        Canvas c;
        while (run) {
            c = null;
            try {
                c = sh.lockCanvas(null);
                if (c == null) {
                    continue;
                }
                c.drawPaint(pcanvas);
                gs.setCanvas(c);
                gs.paintAll();

                if(up){
                   gs.changedPlace(xTap,yTap,xUp,yUp);
                }
                up=false;
            } finally {
                if (c != null) {
                    sh.unlockCanvasAndPost(c);
                }
            }

        }
    }
}
