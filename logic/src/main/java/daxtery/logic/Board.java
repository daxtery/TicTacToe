package daxtery.logic;

import java.util.ArrayList;
import java.util.List;;

/**
 * Board
 */
public final class Board {

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

    public static final int COLUMNS = 3;
    public static final int LINES = 3;

    public static final int SIZE = COLUMNS * LINES;

    private Tile[] tileArray = new Tile[COLUMNS * LINES];

    public Board() {
        for (int i = 0; i < tileArray.length; i++) {
            tileArray[i] = new Tile();
        }
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

    public List<Integer> getWinConfiguration(Player currentPlayer) {
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
                return null;
        }

        List<Integer> win = new ArrayList<>(Board.SIZE);

        for (int i = 0; i < restOfWaysToWin.get(0).length; i++) {
            win.add(restOfWaysToWin.get(0)[i]);
        }

        return win;
    }

    public void set(int index, Player newType) {
        tileArray[index].setPlayer(newType);
    }

    public boolean allFull() {
        for (Tile t : tileArray) {
            if (t.isFree()) {
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
        return s;
    }

    public void reset() {
        for (Tile t : tileArray) {
            t.reset();
        }
    }

}
