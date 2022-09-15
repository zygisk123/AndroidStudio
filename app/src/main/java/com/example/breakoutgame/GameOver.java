package com.example.breakoutgame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

// GameOver is a panel which draws th text game over to the screen
public class GameOver {
    private Context context;

    public GameOver(Context context){
        this.context = context;
    }

    public void draw(Canvas canvas) {
        String text = "Game over";
        int color = ContextCompat.getColor(context, R.color.gameover);
        float x = 30;
        float y = 500;
        float textSize = 150;
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setTextSize(textSize);
        canvas.drawText(text, x, y, paint);
    }

}
