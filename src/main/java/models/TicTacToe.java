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

    private Type currentPlayer = Type.X;
    private int playerTurn = 0;

    private boolean ai = false;
    // private AI theAI;

    private Tile[] tileArray = new Tile[COLUMNS * LINES];

    // private void newAIGame() {
    // resetTiles();
    // if (playerTurn == 1) {
    // theAI.play();
    // }
    // if (!p2.equalsIgnoreCase(pcName)) {
    // p1Wins = 0;
    // p2Wins = 0;
    // p2 = "PC";
    // }
    // GAME_FRAME.repaint();
    // }

    public TicTacToe() {
        for (int i = 0; i < tileArray.length; i++) {
            tileArray[i] = new Tile();
        }
    }

    Tile[] getTiles() {
        return tileArray;
    }

    private void reset() {
        for (Tile t : tileArray)
            t.reset();
    }

    public boolean won(Type currentPlayer) {

        int lookingFor = currentPlayer.ordinal();
        List<int[]> restOfWaysToWin = new ArrayList<>(possible_wins);

        for (int i = 0; i < tileArray.length; i++) {

            int waysSize = restOfWaysToWin.size();

            for (int w = waysSize - 1; w >= 0; w--) {
                if (restOfWaysToWin.get(w)[i] == 1) {
                    if (lookingFor != tileArray[i].getOwner().ordinal()) {
                        restOfWaysToWin.remove(w);
                    }
                }
            }

            if (restOfWaysToWin.size() == 0)
                return false;
        }

        return true;
    }

    public void set(int index, Type newOwner) {
        tileArray[index].set(newOwner);
    }

    // private boolean winningArray(int[] have, int[] need) {
    // // System.out.println();
    // // System.out.println("NEW ARRAY");
    // for (int i = 0; i < have.length; i++) {
    // int hav = have[i];
    // int ned = need[i];
    // // System.out.println("Board: " + hav + " == " + "Needed: " + ned );
    // if (ned == 1 && hav == 0) {
    // return false;
    // }
    // }
    // return true;
    // }

    private int[] capturedTilesFor(Type player) {
        int[] captures = new int[COLUMNS * LINES];
        int i = 0;
        for (Tile t : tileArray) {
            if (t.getOwner() == player) {
                captures[i] = 1;
            }
            i++;
        }
        // for (int ii : captures){
        // System.out.println(ii);
        // }
        return captures;
    }

    private boolean allFull() {
        for (Tile t : tileArray) {
            if (!t.isCaptured()) {
                return false;
            }
        }
        return true;
    }

    // private void nextTurn() {
    // currentPlayer = Type.O;
    // if (playerTurn == 0) {
    // playerTurn++;
    // if (ai) {
    // theAI.play();
    // }
    // } else {
    // playerTurn = 0;
    // }
    // }
}
