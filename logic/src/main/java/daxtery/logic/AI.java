package daxtery.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class AI {

    private AI() {
    }

    public static AIMove getBestMove(Board currentBoard, Mark mark) {
        ArrayList<AIMove> possible = new ArrayList<>(Board.SIZE);
        getBestMove(currentBoard, mark, possible);

        possible.sort((a, b) -> Integer.compare(b.score, a.score));
        return possible.get(0);
    }

    private static int getBestMove(Board currentBoard, Mark mark, List<AIMove> possibleMoves) {
        if (!currentBoard.getWinningConfiguration(mark).isEmpty())
            return 1;

        if (!currentBoard.getWinningConfiguration(mark.getOpposite()).isEmpty())
            return -1;

        if (currentBoard.allFull())
            return 0;

        for (int i = 0; i < Board.SIZE; i++) {
            Optional<Mark> thisMark = currentBoard.get(i);
            if (thisMark.isEmpty()) {
                currentBoard.set(i, mark);
                int score = -getBestMove(currentBoard, mark.getOpposite(), new ArrayList<>());

                possibleMoves.add(new AIMove(score, i));
            }
            currentBoard.set(i, thisMark.orElse(null));
        }

        possibleMoves.sort((a, b) -> Integer.compare(b.score, a.score));
        return possibleMoves.get(0).score;
    }

    public record AIMove(int score, int index) {
    }
}
