package com.example.breakoutgame;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.google.android.gms.common.util.ArrayUtils;


// Game manages all object in the game and is responsible for all states and render
// all objects to the screen

public class Game extends SurfaceView implements SurfaceHolder.Callback {
    private final Player player;
    private final Ball ball;
    private final LevelMaker level;
    private final GameLoop gameLoop;
    private final Context context;
    private float temporary_x;
    private float playerSpeed;
    private Brick[] bricks;
    private Heart[] hearts;

    public Game(Context context) {
        super(context);

        //Get surface holder and add callback
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        this.context = context;
        gameLoop = new GameLoop(this, surfaceHolder);

        //initialize player
        player = new Player(getContext());
        ball = new Ball(getContext(),15);
        level = new LevelMaker(getContext());
        float rangeX = (5f - (-5f)) + 1f;
        ball.ballSpeedX = (float)Math.floor(Math.random() * rangeX) + (-2f);
        float rangeY = (5f - 4f) + 1f;
        ball.ballSpeedY = (float)Math.floor(Math.random() * rangeY) + 4f;
        setFocusable(true);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // handle touch event actions
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_MOVE:
                temporary_x = player.paddleX;
                player.setPosition(event.getX());
                playerSpeed = temporary_x - player.paddleX;
                return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        gameLoop.startLoop();

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawFPS(canvas);
       // drawUPS(canvas);

        player.draw(canvas);
        ball.draw(canvas);
        level.draw(canvas);
    }

    public void drawFPS(Canvas canvas){
        String averageFPS = Double.toString(gameLoop.getAverageFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.magenta);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("FPS: " + averageFPS, 100, 300, paint);
    }

    public void update() {
        // Update game state
        player.update();
        ball.update();
        level.update();

        // check ball collision
        if(ball.collides(player)){
            ball.ballY = player.paddleY - player.height / 2.0 - ball.radius / 2 ;
            ball.ballSpeedY = -ball.ballSpeedY;
            // SOUND
            // if we hit the paddle on its left side while moving left...
            if (ball.ballX < player.paddleX + (player.width / 2.0) && playerSpeed > 5) {
                ball.ballSpeedX = -0.3 + (-(0.4 * (player.paddleX + player.width / 2.0 - ball.ballX)));
            }

            // else if we hit the paddle on its right side while moving right...
            else if (ball.ballX > player.paddleX + (player.width / 2.0) && playerSpeed < -5) {
                ball.ballSpeedX = 0.3 + (0.4 * Math.abs(player.paddleX + player.width / 2.0 - ball.ballX));
            }

        }

        hearts = player.hearts;
        for (int i = 0; i < player.health; i++){
            hearts[i].draw();
        }
        bricks = level.bricks;
        for (int j = 0; j < level.NumOfBricks; j++){
            if(!bricks[j].isDestroyed){
                bricks[j].draw();
            }
        }
        for (int i = 0; i < level.NumOfBricks; i++){
            if (ball.collides(bricks[i])){
                // ball RIGHT brick LEFT
                if (ball.ballX + ball.radius > bricks[i].x && ball.ballSpeedX > 0){
                    ball.ballX = bricks[i].x - ball.radius;
                    ball.ballSpeedX = -ball.ballSpeedX;
                    bricks[i].isDestroyed = true;
                    break;
                }
                // ball LEFT brick RIGHT
                if (ball.ballX - ball.radius < bricks[i].x + bricks[i].width&& ball.ballSpeedX < 0){
                    ball.ballX = bricks[i].x + bricks[i].width + ball.radius;
                    ball.ballSpeedX = -ball.ballSpeedX;
                    bricks[i].isDestroyed = true;
                    break;
                }
                // ball bottom brick top
                if (ball.ballY  + ball.radius > bricks[i].y && ball.ballSpeedY > 0){
                    ball.ballY = bricks[i].y - ball.radius;
                    ball.ballSpeedY = -ball.ballSpeedY;
                    bricks[i].isDestroyed = true;
                    break;
                }
                // ball top brick bottom
                if (ball.ballY - ball.radius < bricks[i].y + bricks[i].height && ball.ballSpeedY < 0){
                    ball.ballY = bricks[i].y + bricks[i].height + ball.radius;
                    ball.ballSpeedY = -ball.ballSpeedY;
                    bricks[i].isDestroyed = true;
                    break;
                }
            }
        }

    }
}
