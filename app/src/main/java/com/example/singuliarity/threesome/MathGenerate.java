package com.example.singuliarity.threesome;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

public class MathGenerate {

    int[][] fullField;
    ArrayList<Integer> image;

    MathGenerate(int colField, int rowField) {

        fullField = new int[colField][rowField];
        image=new ArrayList<Integer>();
        image.add(R.drawable.boobs);
        image.add(R.drawable.skull);
        image.add(R.drawable.doom);
        image.add(R.drawable.crystal);
        image.add(R.drawable.halo);
    }

    int[][] fillScreen() {
        int sizeField = fullField.length;
        for (int i = 0; i < sizeField; i++) {
            int sizeSecondField = fullField[i].length;
            for (int j = 0; j < sizeSecondField; j++) {
                fullField[i][j] = (int) Math.round(Math.random() * 4);
            }
        }
        return fullField;
    }

    int conformity(int pic){
        return image.get(pic);
    }

    int[] getImageTap(int x, int y){
        int numX=(int) Math.ceil(x/200);
        int numY=(int) Math.ceil(y/200);
       return new int[] {numX,numY};
    }

    void changePlaceImage(int x1,int y1,int x2,int y2){
        int[] substituteImage=getImageTap(x1,y1);
        int[] replaceableImage=getImageTap(x2,y2);
        int interValue=fullField[substituteImage[0]][substituteImage[1]];
        fullField[substituteImage[0]][substituteImage[1]]=fullField[replaceableImage[0]][replaceableImage[1]];
        fullField[replaceableImage[0]][replaceableImage[1]]=interValue;

    }

}
