package com.javarush.games.minigames.mini08;

import com.javarush.engine.cell.*;

/* 
Работа с клавиатурой
*/

public class KeyboardGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(3, 3);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
    }

    @Override
    public void onKeyPress(Key key) {
            if (key == Key.LEFT)  {
                for (int y = 0; y < 3; y++) {
                    setCellColor(0, y, Color.GREEN);
                }
            } else if (key == Key.RIGHT) {
                for (int y = 0; y < 3; y++) {
                    setCellColor(2, y, Color.GREEN);
                }
            } else if (key == Key.UP) {
                for (int x = 0; x < 3; x++) {
                    setCellColor(x, 0, Color.GREEN);
                }
            } else {
                for (int x = 0; x < 3; x++) {
                    setCellColor(x, 2, Color.GREEN);
                }
            }
        }


    public void onKeyReleased(Key key) {
        if (key == Key.LEFT || key == Key.UP || key == Key.RIGHT || key == Key.DOWN ) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    setCellColor(x,y,Color.WHITE);
                }
            }
        }
    }
}

