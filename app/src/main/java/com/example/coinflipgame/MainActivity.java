package com.example.coinflipgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button buttonFlip;
    ImageView coinImageView;
    Random randomElement;

    TextView headPointsTv, tailsPointsTv;

    int coinSide; // 0 for heads && 1 for tails
    int counterHeadsPoints = 0, counterTailsPoints = 0;

    private SoundPlayer soundPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonFlip = findViewById(R.id.buttonFlip);
        coinImageView = findViewById(R.id.coinImageView);
        headPointsTv = findViewById(R.id.headPointsTv);
        tailsPointsTv = findViewById(R.id.tailsPointsTv);

        soundPlayer = new SoundPlayer(this);
        randomElement = new Random();

        buttonFlip.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                sleepAfterPressFlipButton();
                soundPlayer.playFlipSound();
                coinSide = randomElement.nextInt(2);

                if (coinSide == 0) {
                    coinImageView.setImageResource(R.drawable.heads);
                    counterHeadsPoints ++;
                    Toast.makeText(MainActivity.this, "It's heads! Click again.", Toast.LENGTH_SHORT).show();
                    headPointsTv.setText("Head Points: " + counterHeadsPoints);

                } else {
                    coinImageView.setImageResource(R.drawable.tails);
                    counterTailsPoints++;
                    Toast.makeText(MainActivity.this, "It's tails! Next round.", Toast.LENGTH_SHORT).show();
                    tailsPointsTv.setText("Tails Points: " + counterTailsPoints);
                }

                RotateAnimation rotation = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotation.setDuration(2500);
                coinImageView.startAnimation(rotation);
            }
        });
    }

    private void sleepAfterPressFlipButton() { // for a small break after press the flip button
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
