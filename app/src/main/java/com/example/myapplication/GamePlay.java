package com.example.myapplication;

import android.view.View;
import android.widget.Button;

class GamePlay {

    private TTTButton[][] tttButtons = new TTTButton[3][3];
    private boolean gameOver;
    private TurnTracker turnTracker;
    private UI ui;


    public GamePlay(UI ui) {
        this.ui = ui;
    }

    public void startNewGame(Button[][] inputButton) {
        int i = 0;
        int j = 0;
        Player player1 = new Player(UI.RED_PLAYER);
        Player player2 = new Player(UI.BLUE_PLAYER);

        for (Button[] buttonRow : inputButton) {
            j = 0;
            for (Button button : buttonRow) {
                tttButtons[i][j] = new TTTButton(button);
                j++;
            }
            i++;
        }
        ui.resetAllButtonColor();
        gameOver = false;
        turnTracker = new TurnTracker(player1, player2);
        ui.showTurn(turnTracker.getCurrentPlayer());
    }

    public void buttonClick(View v) {
        Player currentPlayer = turnTracker.getCurrentPlayer();

        try {
            Coordinate buttonPosition = getButtonPosition(v);

            assignTTTButtonToPlayer(buttonPosition);
            currentPlayer.takeThisButton(buttonPosition);
            currentPlayer.changeButtonColor(ui, v);

            if (currentPlayer.isWinning()) {
                gameOver(currentPlayer);
            } else if (buttonRunsOut()) {
                gameOver();
            } else {
                turnTracker.switchTurn();
                ui.showTurn(turnTracker.getCurrentPlayer());
            }

        } catch (GameOverException goe) {
            ui.showGameOverMsg();
        } catch (DoubleClickException dce) {
            ui.showDoubleClickMsg();
        }
    }

    private boolean buttonRunsOut() {
       for (TTTButton[] buttonRow : tttButtons) {
            for (TTTButton button : buttonRow) {
                if (!button.isClicked) {
                    return false;
                }
            }
        }
       return true;
    }

    public void gameOver() {
        ui.showDraw();
        gameOver = true;
    }

    public void gameOver(Player winner) {
        ui.showWinner(winner);
        gameOver = true;
    }

    public void assignTTTButtonToPlayer(Coordinate coordinate)
            throws DoubleClickException, GameOverException {

        TTTButton clickedButton = tttButtons[coordinate.x][coordinate.y];

        if (gameOver) {
            throw new GameOverException();
        }
        if (clickedButton.isClicked()) {
            throw new DoubleClickException();
        }
        clickedButton.assignTTTButtonToPlayer();
    }

    public Coordinate getButtonPosition(View v) {
        Coordinate pos = new Coordinate();
        int i = 0;
        int j = 0;

        for (TTTButton[] tttButtonRow : tttButtons) {
            j = 0;
            for (TTTButton button : tttButtonRow) {
                if (button.getButton() == v) {
                    pos.setCoordinate(i,j);
                }
                j++;
            }
            i++;
        }

        return pos;
    }

}
