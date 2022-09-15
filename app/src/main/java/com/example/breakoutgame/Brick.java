package com.example.breakoutgame;

import android.content.Context;
import android.graphics.Canvas;

import com.example.breakoutgame.graphics.Sprite;
import com.example.breakoutgame.graphics.SpriteSheet;
public class Brick {

    private final SpriteSheet spriteSheet;
    public int height;
    public int width;
    public boolean isDestroyed;
    private Sprite sprite;
    private Canvas canvas;
    private int id;
    public int x;
    public int y;
    public int left;
    public int top;
    public int right;
    public int bottom;

    public Brick(Context context, int x, int y) {
        this.sprite = sprite;
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.width = 60;
        this.height = 30;
        this.left = 0;
        this.top = 0;
        this.right = 60;
        this.bottom = 30;
        this.isDestroyed = false;
        spriteSheet = new SpriteSheet(context);
        this.sprite = spriteSheet.getBlockSprite(left,top,right,bottom);
    }

    public void draw(Canvas canvas) {
        if (!isDestroyed){
            sprite.draw(canvas, x, y, width, height);
        }
    }

    public void update() {
       // if(!isDestroyed){
       //     draw();
       // }
    }
}
