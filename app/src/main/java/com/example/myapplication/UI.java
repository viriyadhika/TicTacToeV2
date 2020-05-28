package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

class UI {

    private TextView showTurn;
    private Button[][] buttons;
    private Context context;

    public static final int RED_PLAYER = Color.RED;
    public static final int BLUE_PLAYER = Color.BLUE;

    private static final String DOUBLE_CLICK_MSG = "That Button is Clicked!";
    private static final String GAME_OVER_MSG = "Dude, the Game is Over -_-";

    public UI(Context context, TextView showTurn, Button[][] buttons){
        this.showTurn =showTurn;
        this.buttons = buttons;
        this.context = context;
    }

    public void resetAllButtonColor() {
        for (Button[] buttonRow: buttons) {
            for (Button button : buttonRow) {
                button.setBackgroundColor(Color.WHITE);
            }
        }
    }

    public void showInToast(String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    public void showDoubleClickMsg() {
        showInToast(DOUBLE_CLICK_MSG);
    }

    public void showGameOverMsg() {
        showInToast(GAME_OVER_MSG);
    }

    public void showWinner(Player p) {showInToast(p + " Wins!");}

    public void showDraw() {
        showInToast("It's A Draw!");
    }

    public void showInTextView(String s) {
        showTurn.setText(s);
    }

    public void showTurn(Player p) {
        showInTextView(p + "'s Turn");
    }

    public void setButtonColor(View v, int color) {
        v.setBackgroundColor(color);
    }
}
