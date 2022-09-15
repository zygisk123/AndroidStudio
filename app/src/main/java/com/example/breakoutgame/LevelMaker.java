package com.example.breakoutgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;

import com.example.breakoutgame.graphics.Sprite;
import com.example.breakoutgame.graphics.SpriteSheet;

import java.util.ArrayList;
import java.util.List;

public class LevelMaker {

    private final Sprite sprite;
    private final Context context;
    public float positionX;
    public float positionY;
    public int left;
    public int top;
    public int right;
    public int bottom;
    public int brickHeight;
    public int brickWidth;
    public int NumOfBricks = 52;
    public SpriteSheet spriteSheet;
    public Brick[] bricks;
    public Brick[] bricks2;
    public Ball ball;
    //List brickList = new ArrayList();



    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public LevelMaker(Context context){
        this.positionX = 100;
        this.positionY = 100;
        this.brickHeight = 30;
        this.brickWidth = 60;
        this.context = context;
        this.left = 0;
        this.top = 0;
        this.right = 60;
        this.bottom = 30;
        spriteSheet = new SpriteSheet(context);
        this.sprite = spriteSheet.getBlockSprite(left,top,right,bottom);
    }
    public void draw(Canvas canvas) {
        bricks(canvas);
      //  for (int i = 0; i < NumOfBricks; i++){
      //      if(!bricks[i].isDestroyed){
      //          bricks[i].draw(canvas);
      //      }
      //  }

    }

    public void update() {


    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Brick[] getBricks(){
        bricks2 = bricks;
        return bricks2;
    }

    public void bricks(Canvas canvas){
        int x;
        int y;
        int id = 0;
        int addX;
        int addY;
        bricks = new Brick[NumOfBricks];
        for (y = 0; y < 4; y++){
            for (x = 0; x < 13; x++){
                addX = (brickWidth + 10) * x;
                addY = (brickHeight + 10) * y;
          //      bricks[id] = new Brick(sprite, canvas, (int) positionX + addX, (int) positionY + addY);
                id++;
            }
        }

    }
}
