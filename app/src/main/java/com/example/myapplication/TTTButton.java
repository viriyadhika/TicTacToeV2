package com.example.myapplication;

import android.app.VoiceInteractor;
import android.os.Build;
import android.widget.Button;

import androidx.annotation.RequiresApi;

import java.util.Optional;

class TTTButton  {

    Button button;
    boolean isClicked;

    public TTTButton(Button b) {
        this.button = b;
        this.isClicked = false;
    }

    public void assignTTTButtonToPlayer() {
        this.isClicked = true;
    }

    public boolean isClicked() {
        return this.isClicked;
    }

    public Button getButton() {
        return button;
    }
}
