package com.example.breakoutgame;

import android.graphics.Canvas;

import com.example.breakoutgame.graphics.Sprite;

public class Heart {
    public int height;
    public int width;
    public boolean isDestroyed;
    private Sprite sprite;
    private Canvas canvas;
    private int id;
    public int x;
    public int y;

    public Heart(Sprite sprite, Canvas canvas, int heartX, int heartY) {
        this.sprite = sprite;
        this.canvas = canvas;
        this.x = heartX;
        this.y = heartY;
        this.width = 30;
        this.height = 30;
        this.isDestroyed = false;
    }

    public void draw() {
        sprite.draw(canvas, x, y, width, height);
    }
}
