package com.example.breakoutgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

public class Ball {
    public double ballSpeedX;
    public double ballSpeedY;
    public double ballX;
    public double ballY;
    public double radius;
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

        // these variables are for keeping track of our velocity on both the
        // X and Y axis, since the ball can move in two dimensions
        this.ballSpeedX = 0;
        this.ballSpeedY = 0;

        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.ball);
        paint.setColor(color);
    }
    public void draw(Canvas canvas) {
        canvas.drawCircle((float) ballX, (float) ballY, (float) radius, paint);
    }

    public void update(Player player) {
        ballX = ballX + ballSpeedX;
        ballY = ballY + ballSpeedY;

        // allow ball to bounce off walls
        if (ballX <= 0){
            ballX = 1;
            ballSpeedX = -ballSpeedX;
            // SOUND
        }
        if (ballX >= getScreenWidth() - radius){
            ballX = getScreenWidth() - radius;
            ballSpeedX = -ballSpeedX;
            // SOUND
        }
        if (ballX <= 0){
            ballX = 0;
            ballSpeedX = -ballSpeedX;
            // SOUND
        }
        if (ballY <= 0){
            ballY = 0;
            ballSpeedY = -ballSpeedY;
            // SOUND
        }
        if (ballY >= getScreenHeight() - radius){
            ballY = getScreenHeight() - radius;
            ballSpeedY = -ballSpeedY;
            // SOUND
        }
    }

    public boolean collides(Player player) {
        if (ballX < player.paddleX + player.width + radius && ballX > player.paddleX - radius && ballY + radius / 2 > player.paddleY - player.heigth / 2 && ballY + radius / 2 <= player.paddleY + player.heigth / 2){
            return true;
        }
        return false;
    }
}
