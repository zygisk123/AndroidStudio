package com.example.breakoutgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import androidx.core.content.ContextCompat;

import com.example.breakoutgame.graphics.Sprite;
import com.example.breakoutgame.graphics.SpriteSheet;

public class Player {
    private final SpriteSheet spriteSheet;
    private int bottom;
    private int right;
    private int top;
    private int left;
    public int width;
    public int height;
    public float paddleX;
    public float paddleY;
    private Paint paint;
    public int health;
    public Heart[] hearts;
    private Sprite sprite;
    public int heartX = 30;
    public int heartY = 30;


    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public Player(Context context){
        this.width = 180;
        this.height = 30;
        this.paddleX = getScreenWidth() / 2 - 50;
        this.paddleY = getScreenHeight() - 195;
        this.health = 3;
        this.left = 0;
        this.top = 31;
        this.right = 30;
        this.bottom = 60;
        spriteSheet = new SpriteSheet(context);
        this.sprite = spriteSheet.getBlockSprite(left,top,right,bottom);
        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.paddle);
        paint.setColor(color);
    }

    public void draw(Canvas canvas) {
        RectF rectF = new RectF(
                paddleX, // left
                paddleY, // top
                paddleX + width, // right
                paddleY + height // bottom
        );
        int cornersRadius = 25;

        // Finally, draw the rounded corners rectangle object on the canvas
        canvas.drawRoundRect(
                rectF, // rect
                cornersRadius, // rx
                cornersRadius, // ry
                paint // Paint
        );
        hearts = new Heart[health];
        for (int i = 0; i < health; i++){
            int addX = 40 * i;
            hearts[i] = new Heart(sprite, canvas, (int) heartX + addX, (int) heartY);
        }
        for (int i = 0; i < health; i++){
            if(!hearts[i].isDestroyed);
            hearts[i].draw();
        }
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
