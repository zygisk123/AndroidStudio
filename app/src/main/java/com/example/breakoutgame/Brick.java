package com.example.breakoutgame;

import android.graphics.Canvas;

import com.example.breakoutgame.graphics.Sprite;
import com.example.breakoutgame.graphics.SpriteSheet;
public class Brick {

    public int height;
    public int width;
    public boolean isDestroyed;
    private Sprite sprite;
    private Canvas canvas;
    private int id;
    public int x;
    public int y;

    public Brick(Sprite sprite, Canvas canvas, int x, int y) {
        this.sprite = sprite;
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.width = 60;
        this.height = 30;
        this.isDestroyed = false;
    }

    public void draw() {
        sprite.draw(canvas, x, y, width, height);
    }

}
