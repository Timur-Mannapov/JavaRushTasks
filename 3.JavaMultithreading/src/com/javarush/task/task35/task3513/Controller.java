package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private Model model;
    private View view;
    private static int WINNING_TILE = 2048;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
        return model.score;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
            resetGame();
        }
        if (!model.canMove()) {
            view.isGameLost = true;
        }
        if (!view.isGameLost && !view.isGameWon) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
                model.left();
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
                model.right();
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
                model.up();
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                model.down();
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_R) {
                model.randomMove();
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_Z) {
                model.rollback();
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_A) {
                model.autoMove();
            }
        }
        if (model.maxTile == WINNING_TILE) {
            view.isGameWon = true;
        }
        view.repaint();

    }

    public View getView() {
        return view;
    }

    public void resetGame() {
        model.score = 0;
        view.isGameWon = false;
        view.isGameLost = false;
        model.resetGameTiles();
    }
}
