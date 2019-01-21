package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.*;

public final class AI {

    private static class AIMove {
        int score;
        int index;

        private AIMove(int score, int index) {
            this.score = score;
            this.index = index;
        }
    }

    private AI() {

    }

    public static int getBestMove(TicTacToe currentBoard, Player player) {
        ArrayList<AIMove> possible = new ArrayList<AIMove>(TicTacToe.SIZE);
        getBestMove(currentBoard, player, possible);

        possible.sort((a, b) -> Integer.compare(b.score, a.score));

        int max = possible.get(0).score;
        int count = 1;
        for (int i = 1; i < possible.size(); i++, count++) {
            if (possible.get(i).score < max) {
                break;
            }
        }

        return possible.get(new Random().nextInt(count)).index;
    }

    private static int getBestMove(TicTacToe currentBoard, Player player, List<AIMove> possibleMoves) {
        if (currentBoard.won(player))
            return 1;

        else if (currentBoard.won(player.getOpposite()))
            return -1;

        if (currentBoard.allFull())
            return 0;

        for (int i = 0; i < TicTacToe.SIZE; i++) {
            Tile t = currentBoard.get(i);
            Player type = t.getPlayer();
            if (!t.isCaptured()) {
                currentBoard.set(i, player);
                int score = -getBestMove(currentBoard, player.getOpposite(), new ArrayList<AIMove>());
                int index = i;

                possibleMoves.add(new AIMove(score, index));
            }
            currentBoard.set(i, type);
        }

        possibleMoves.sort((a, b) -> Integer.compare(b.score, a.score));
        return possibleMoves.get(0).score;
    }
}
