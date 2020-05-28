package com.example.myapplication;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.HashSet;
import java.util.Set;

class Player {

    private int color;
    private Set<Coordinate> takenButtons = new HashSet<>();

    public Player(int color) {
        this.color = color;
    }


    public void changeButtonColor(UI ui, View v) {
        ui.setButtonColor(v, this.color);
    }

    public void takeThisButton(Coordinate c) {
        takenButtons.add(c);
    }


    public boolean isWinning() {
        return horizontalWinning() || verticalWinning() || diagonalWinning();
    }

    private boolean diagonalWinning() {
        return
                (takenButtons.contains(new Coordinate(0,0)) &&
                takenButtons.contains(new Coordinate(1,1)) &&
                takenButtons.contains(new Coordinate(2,2))) ||

                (takenButtons.contains(new Coordinate(0,2)) &&
                takenButtons.contains(new Coordinate(1,1)) &&
                takenButtons.contains(new Coordinate(2,0)));
    }

    private boolean verticalWinning() {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for (Coordinate c : takenButtons) {
            switch (c.y) {
                case 0:
                    count1++;
                    break;
                case 1:
                    count2++;
                    break;
                case 2:
                    count3++;
                    break;
            }
        }
        return (count1 == 3) || (count2 == 3) || (count3 == 3);
    }

    private boolean horizontalWinning() {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for (Coordinate c : takenButtons) {
            switch (c.x) {
                case 0:
                    count1++;
                    break;
                case 1:
                    count2++;
                    break;
                case 2:
                    count3++;
                    break;
            }
        }
        return (count1 == 3) || (count2 == 3) || (count3 == 3);
    }


    @NonNull
    @Override
    public String toString() {
    String s = "";

    switch (color) {
        case UI.BLUE_PLAYER:
            s = "Blue";
            break;
        case UI.RED_PLAYER:
            s = "Red";
            break;
    }

    return s;
    }

}
