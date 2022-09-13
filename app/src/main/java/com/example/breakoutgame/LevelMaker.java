package com.example.breakoutgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;

import com.example.breakoutgame.graphics.Sprite;
import com.example.breakoutgame.graphics.SpriteSheet;

import java.util.ArrayList;
import java.util.List;

public class LevelMaker {

    public float positionX;
    public float positionY;
    public int left;
    public int top;
    public int right;
    public int bottom;
    public int blockHeight;
    public int blockWidth;
    SpriteSheet spriteSheet;
    private Block block;
    List blockList = new ArrayList();



    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    private Sprite sprite;
    public LevelMaker(Context context){
        this.positionX = 50;
        this.positionY = 50;
        this.blockHeight = 30;
        this.blockWidth = 60;
        this.left = 0;
        this.top = 0;
        this.right = 60;
        this.bottom = 30;
        spriteSheet = new SpriteSheet(context);
        sprite = spriteSheet.getBlockSprite(left,top,right,bottom);
    }
    public void draw(Canvas canvas) {
        int x;
        int y;
        int id = 0;
        int addX;
        int addY;
        for (y = 0; y < 5; y++){
            for (x = 0; x < 14; x++){
                addX = (blockWidth + 10) * x;
                addY = (blockHeight + 10) * y;
                id++;
                block = new Block(sprite, canvas, (int) id, (int) positionX + addX, (int) positionY + addY);
                blockList.add(block);
            }
        }
    //    for (int i = 0; i <= blockList.size(); i++){
    //        blockList.get(i);
    //    }

    }

    public void update() {
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
