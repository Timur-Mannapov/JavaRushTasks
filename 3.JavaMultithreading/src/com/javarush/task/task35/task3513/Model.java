package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    int score = 0;
    int maxTile = 2;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }


    public void resetGameTiles() {
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty()) {
            int randomIndex = (int) (Math.random() * emptyTiles.size());
            Tile tile = emptyTiles.get(randomIndex);
            tile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }


    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    list.add(gameTiles[i][j]);
                }
            }
        }
        return list;
    }

    private boolean compressTiles(Tile[] tiles) {
        int insertPosition = 0;
        boolean result = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (!tiles[i].isEmpty()) {
                if (i != insertPosition) {
                    tiles[insertPosition] = tiles[i];
                    tiles[i] = new Tile();
                    result = true;
                }
                insertPosition++;
            }
        }
        return result;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean result = false;
        LinkedList<Tile> tilesList = new LinkedList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (tiles[i].isEmpty()) {
                continue;
            }

            if (i < FIELD_WIDTH - 1 && tiles[i].value == tiles[i + 1].value) {
                int updatedValue = tiles[i].value * 2;
                if (updatedValue > maxTile) {
                    maxTile = updatedValue;
                }
                score += updatedValue;
                tilesList.addLast(new Tile(updatedValue));
                tiles[i + 1].value = 0;
                result = true;
            } else {
                tilesList.addLast(new Tile(tiles[i].value));
            }
            tiles[i].value = 0;
        }

        for (int i = 0; i < tilesList.size(); i++) {
            tiles[i] = tilesList.get(i);
        }

        return result;
    }

    private Tile[][] turn(Tile[][] tiles) {
        int column = tiles.length;
        int row = tiles[0].length;
        Tile[][] turnTiles = new Tile[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                turnTiles[j][row - 1 - i] = tiles[i][j];
            }
        }
        return turnTiles;
    }

    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean flag = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                flag = true;
            }
        }
        if (flag) {
            addTile();
        }
        isSaveNeeded = true;
    }


    public void right() {
        saveState(gameTiles);
        gameTiles = turn(gameTiles);
        gameTiles = turn(gameTiles);
        left();
        gameTiles = turn(gameTiles);
        gameTiles = turn(gameTiles);
    }

    public void up() {
        saveState(gameTiles);
        gameTiles = turn(gameTiles);
        gameTiles = turn(gameTiles);
        gameTiles = turn(gameTiles);
        left();
        gameTiles = turn(gameTiles);
    }

    public void down() {
        saveState(gameTiles);
        gameTiles = turn(gameTiles);
        left();
        gameTiles = turn(gameTiles);
        gameTiles = turn(gameTiles);
        gameTiles = turn(gameTiles);
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private int getEmptyTilesCount() {
        return getEmptyTiles().size();
    }

    private boolean isFull() {
        return getEmptyTilesCount() == 0;
    }

    boolean canMove() {
        if (!isFull()) {
            return true;
        }
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) {
                    return true;
                }
                if (i < FIELD_WIDTH - 1) {
                    if (gameTiles[i][j].value == gameTiles[i + 1][j].value) {
                        return true;
                    }
                }
                if (j < FIELD_WIDTH - 1) {
                    if (gameTiles[i][j].value == gameTiles[i][j + 1].value) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] tempTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tempTiles[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(tempTiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int n = (int) ((Math.random() * 100) % 4);
        switch (n) {
            case (0):
                left();
                break;
            case (1):
                right();
                break;
            case (2):
                up();
                break;
            case (3):
                down();
                break;
        }
    }

    private MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        move.move();
        if (!hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;

    }

    private boolean hasBoardChanged() {
        Tile[][] tempTiles = previousStates.peek();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].value != tempTiles[i][j].value) {
                    return true;
                }
            }
        }
        return false;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4,Collections.reverseOrder());
        queue.offer(getMoveEfficiency(this::down));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::right));

        queue.peek().getMove().move();
    }
}
