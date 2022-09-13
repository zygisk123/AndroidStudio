package com.example.breakoutgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;

import com.example.breakoutgame.graphics.Sprite;
import com.example.breakoutgame.graphics.SpriteSheet;

public class LevelMaker {

    private float positionX;
    private float positionY;
    private int left;
    private int top;
    private int right;
    private int bottom;
    private int blockHeight;
    private int blockWidth;
    SpriteSheet spriteSheet;

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
        int addX;
        int addY;
        for (y = 0; y < 5; y++){
            for (x = 0; x < 14; x++){
                addX = (blockWidth + 10) * x;
                addY = (blockHeight + 10) * y;
                sprite.draw(canvas, (int) positionX + addX, (int) positionY + addY);
            }
        }
    }

    public void update() {
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
