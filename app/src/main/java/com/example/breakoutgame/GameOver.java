package com.example.breakoutgame;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.breakoutgame.databinding.ActivityGameOverBinding;

public class GameOver extends AppCompatActivity {

    TextView tvPoints;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
       // int points = getIntent().getExtras().getInt("points");
       // tvPoints = findViewById(R.id.tvPoints);
       // tvPoints.setText("" + points);
    }

    public void restart(View view) {
        Intent intent = new Intent(GameOver.this, Game.class);
        startActivity(intent);
        finish();
    }

    public void exit(View view) {
        finish();
    }
}