package com.example.breakoutgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

public class Ball {
    private double ballX;
    private double ballY;
    private double radius;
    private Paint paint;
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public Ball(Context context, double radius){
        this.ballX = getScreenWidth() / 2 - radius / 2;
        this.ballY = getScreenHeight() / 2 - radius / 2;
        this.radius = radius;

        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.ball);
        paint.setColor(color);
    }
    public void draw(Canvas canvas) {
        canvas.drawCircle((float) ballX, (float) ballY, (float) radius, paint);
    }

    public void update() {
    }
}
