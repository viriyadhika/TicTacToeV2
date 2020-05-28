package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GamePlay gamePlay;

    private TextView showTurn;
    private Button[][] buttons;
    private UI ui;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTurn = findViewById(R.id.showTurn);
        buttons = addAllButtons();
        ui = new UI(getApplicationContext(), showTurn, buttons);
        startNewGame();
    }

    public void startNewGame() {
        gamePlay = new GamePlay(ui);
        gamePlay.startNewGame(buttons);
    }

    public void buttonClick(View v) {
        gamePlay.buttonClick(v);
    }

    public void resetButtonClick(View v) {
        startNewGame();
    }

    public Button[][] addAllButtons() {
        Button[][] finalList = new Button[3][3];

        Button[] topRow = new Button[3];
        Button[] midRow = new Button[3];
        Button[] bottomRow = new Button[3];

        topRow[0] = findViewById(R.id.leftTop);
        topRow[1] = findViewById(R.id.centerTop);
        topRow[2] = findViewById(R.id.rightTop);

        midRow[0] = findViewById(R.id.leftMid);
        midRow[1]= findViewById(R.id.centerMid);
        midRow[2] = findViewById(R.id.rightMid);

        bottomRow[0] = findViewById(R.id.leftBottom);
        bottomRow[1] = findViewById(R.id.centerBottom);
        bottomRow[2] = findViewById(R.id.rightBottom);

        finalList [0] = topRow;
        finalList [1] = midRow;
        finalList [2] = bottomRow;

        return finalList;
    }

}
