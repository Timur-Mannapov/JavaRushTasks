package com.javarush.games.minigames.mini05;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Цвета радуги
*/

public class RainbowGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(10, 7);
        Color red = Color.RED;
        Color orange = Color.ORANGE;
        Color yellow = Color.YELLOW;
        Color green = Color.GREEN;
        Color blue = Color.BLUE;
        Color indigo = Color.INDIGO;
        Color violet = Color.VIOLET;
        Color[] allColor = new Color[]{red, orange, yellow, green, blue, indigo, violet};
        for (int i = 0; i < getScreenHeight(); i++) {
            for (int j = 0; j < getScreenWidth(); j++) {
                setCellColor(j, i, allColor[i]);
            }
        }
    }
}
