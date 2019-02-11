package com.example.singuliarity.threesome;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

public class GenerateScreen {

    Canvas canvas;
    Paint p;
    Path path;
    Bitmap bmp;
    Context ctx;
    MathGenerate mathGen;
    int[][] allScreen;


    GenerateScreen(int numberGen,Context ctx) {
        p=new Paint();
        p.setColor(Color.BLACK);
        p.setStrokeWidth(5);
        p.setStyle(Paint.Style.STROKE);
        path=new Path();
        this.ctx=ctx;
        mathGen=new MathGenerate(5,5);
        allScreen= mathGen.fillScreen();
    }

    void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
    void getCoordTap(int x,int y){
        mathGen.getImageTap(x,y);
    }

    void changedPlace(int x1,int y1,int x2,int y2){
        mathGen.changePlaceImage(x1,y1,x2,y2);
    }
    void paintAll() {
        int sizeFirst=allScreen.length;
        for(int i=0;i<sizeFirst;i++){
            int sizeSecond=allScreen[i].length;
            for(int j=0;j<sizeSecond;j++){
                bmp=BitmapFactory.decodeResource(ctx.getResources(),mathGen.conformity(allScreen[i][j]));

                canvas.drawBitmap(bmp, new Rect(0,0,200,200),
                        new Rect(i*200,j*200,i*200+100,j*200+100), null);
            }
        }
    }
}
