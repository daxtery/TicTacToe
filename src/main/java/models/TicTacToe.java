package models;

import java.util.ArrayList;
import java.util.List;;

/**
 * TicTacToe
 */
public final class TicTacToe {

    private static final List<int[]> POSSIBLE_WINS = new ArrayList<>() {
        private static final long serialVersionUID = 1655370451954117204L;

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

    public boolean won(Player currentPlayer) {

        int lookingFor = currentPlayer.ordinal();
        List<int[]> restOfWaysToWin = new ArrayList<>(POSSIBLE_WINS);

        for (int i = 0; i < tileArray.length; i++) {

            int waysSize = restOfWaysToWin.size();

            for (int w = waysSize - 1; w >= 0; w--) {
                if (restOfWaysToWin.get(w)[i] == 1) {
                    if (lookingFor != tileArray[i].getPlayer().ordinal()) {
                        restOfWaysToWin.remove(w);
                    }
                }
            }

            if (restOfWaysToWin.size() == 0)
                return false;
        }

        return true;
    }

    public void set(int index, Player newType) {
        tileArray[index].setPlayer(newType);
    }

    public boolean allFull() {
        for (Tile t : tileArray) {
            if (!t.isCaptured()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < SIZE; i++) {
            s += tileArray[i].getPlayer().toString();
            if ((i + 1) % COLUMNS == 0) {
                s += "\n";
            } else {
                s += " ";
            }
        }
        return s.toString();
    }

}
