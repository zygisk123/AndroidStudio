package com.example.breakoutgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import androidx.core.content.ContextCompat;

public class Player {
    public int width;
    public int heigth;
    public float paddleX;
    public float paddleY;
    private Paint paint;

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public Player(Context context){
        this.width = 180;
        this.heigth = 30;
        this.paddleX = getScreenWidth() / 2 - 50;
        this.paddleY = getScreenHeight() - 195;

        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.paddle);
        paint.setColor(color);
    }

    public void draw(Canvas canvas) {
        RectF rectF = new RectF(
                paddleX, // left
                paddleY, // top
                paddleX + width, // right
                paddleY + heigth // bottom
        );
        int cornersRadius = 25;

        // Finally, draw the rounded corners rectangle object on the canvas
        canvas.drawRoundRect(
                rectF, // rect
                cornersRadius, // rx
                cornersRadius, // ry
                paint // Paint
        );
    }

    public void update() {
        checkCollision();
    }

    public void setPosition(float paddleX) {
        this.paddleX = paddleX;
    }

    public void checkCollision() {
        float screen_left_corner = 0;
        float screen_right_corner = getScreenWidth();
        if (this.paddleX <= screen_left_corner) {
            paddleX = screen_left_corner;
        }
        else if (this.paddleX >= screen_right_corner - width){
            paddleX = screen_right_corner - width;
        }
    }
}
