package com.example.breakoutgame;

import android.graphics.Canvas;

import com.example.breakoutgame.graphics.Sprite;

public class Block {

    private final Sprite sprite;
    private Canvas canvas;
    private int id;
    private int x;
    private int y;

    public Block(Sprite sprite, Canvas canvas, int id, int x, int y) {
        this.sprite = sprite;
        this.canvas = canvas;
        this.id = id;
        this.x = x;
        this.y = y;
        draw();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public void draw() {
        sprite.draw(canvas, x, y);
    }
}
