package game;

import java.util.List;

/**
 * Helper
 */
public class Helper {

    private Helper() {

    }

    public static int[] indexesOfWin(List<Integer> winningArray) {

        int[] indexes = new int[3];
        int current = 0;

        for (int i = 0; i < winningArray.size(); i++) {
            if (winningArray.get(i) == 1) {
                indexes[current++] = i;
            }
        }

        return indexes;
    }

}