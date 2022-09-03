package com.example.coinflipgame;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;

public class SoundPlayer {

    private static SoundPool soundPool;
    private static int flipCoinSound;

    SoundPlayer(Context context) {
        AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME).setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build();
        soundPool = new SoundPool.Builder().setAudioAttributes(audioAttributes).setMaxStreams(2).build();
        flipCoinSound = soundPool.load(context, R.raw.coinflip, 1);
    }

    void playFlipSound() {
        soundPool.play(flipCoinSound, 1.0f, 1.0f, 1, 0, 1.0f);
    }
}