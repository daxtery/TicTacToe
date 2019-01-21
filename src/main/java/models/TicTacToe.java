package models;

import java.util.ArrayList;
import java.util.List;;

/**
 * TicTacToe
 */
public final class TicTacToe {

    private static List<int[]> possible_wins = new ArrayList<>() {
        {
            add(new int[] { //
                    1, 0, 0, //
                    1, 0, 0, //
                    1, 0, 0 });
            add(new int[] { //
                    0, 1, 0, //
                    0, 1, 0, //
                    0, 1, 0 });
            add(new int[] { //
                    0, 0, 1, //
                    0, 0, 1, //
                    0, 0, 1 });
            add(new int[] { //
                    1, 1, 1, //
                    0, 0, 0, //
                    0, 0, 0 });
            add(new int[] { //
                    0, 0, 0, //
                    1, 1, 1, //
                    0, 0, 0 });
            add(new int[] { //
                    0, 0, 0, //
                    0, 0, 0, //
                    1, 1, 1 });
            add(new int[] { //
                    1, 0, 0, //
                    0, 1, 0, //
                    0, 0, 1 });
            add(new int[] { //
                    0, 0, 1, //
                    0, 1, 0, //
                    1, 0, 0 });
        }
    };

    private static final int COLUMNS = 3;
    private static final int LINES = 3;

    public static final int SIZE = COLUMNS * LINES;

    private Tile[] tileArray = new Tile[COLUMNS * LINES];

    public TicTacToe() {
        for (int i = 0; i < tileArray.length; i++) {
            tileArray[i] = new Tile();
        }
    }

    public Tile[] getTiles() {
        return tileArray;
    }

    public Tile get(int index) {
        return tileArray[index];
    }

    public boolean won(Type currentPlayer) {

        int lookingFor = currentPlayer.ordinal();
        List<int[]> restOfWaysToWin = new ArrayList<>(possible_wins);

        for (int i = 0; i < tileArray.length; i++) {

            int waysSize = restOfWaysToWin.size();

            for (int w = waysSize - 1; w >= 0; w--) {
                if (restOfWaysToWin.get(w)[i] == 1) {
                    if (lookingFor != tileArray[i].getType().ordinal()) {
                        restOfWaysToWin.remove(w);
                    }
                }
            }

            if (restOfWaysToWin.size() == 0)
                return false;
        }

        return true;
    }

    public void set(int index, Type newType) {
        tileArray[index].setType(newType);
    }

    public boolean allFull() {
        for (Tile t : tileArray) {
            if (!t.isCaptured()) {
                return false;
            }
        }
        return true;
    }

}
