package daxtery.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TicTacToeTest {

    private static Board fromString(Mark... marks) {
        var board = new Board();
        for (int i = 0; i < marks.length; i++) {
            board.set(i, marks[i]);
        }
        return board;
    }

    private static Stream<Arguments> boardAndExpectedWinnerProvider() {
        return Stream.of(
                Arguments.of(fromString(Mark.O, Mark.O, Mark.O), Mark.O),
                Arguments.of(fromString(null, null, null, Mark.O, Mark.O, Mark.O), Mark.O),
                Arguments.of(fromString(null, null, null, null, null, null, Mark.O, Mark.O, Mark.O), Mark.O),
                Arguments.of(fromString(Mark.O, Mark.O, Mark.X, Mark.O, Mark.X, Mark.O, Mark.O, Mark.O, Mark.X), Mark.O),
                Arguments.of(fromString(Mark.O, Mark.X, Mark.O, Mark.X, Mark.O, Mark.X, Mark.O, null, null), Mark.O)
        );
    }

    public static Stream<Arguments> boardAndExpectedLoserProvider() {
        return Stream.of(
                Arguments.of(fromString(Mark.O, Mark.X, Mark.O), Mark.O),
                Arguments.of(fromString(null, null, null, Mark.O, Mark.X, Mark.O), Mark.O),
                Arguments.of(fromString(null, null, null, null, null, null, Mark.O, Mark.X, Mark.O), Mark.O),
                Arguments.of(fromString(null, null, null, null, null, Mark.O, null, Mark.O, Mark.O), Mark.O),
                Arguments.of(fromString(null, null, null, null, null, Mark.X, null, Mark.X, Mark.X), Mark.X),
                Arguments.of(fromString(Mark.X, Mark.O, Mark.X, Mark.O, Mark.X, Mark.O, Mark.O, Mark.X, Mark.O), Mark.X),
                Arguments.of(fromString(Mark.X, Mark.O, Mark.X, Mark.O, Mark.X, Mark.O, Mark.O, Mark.X, Mark.O), Mark.O)
        );
    }

    @ParameterizedTest
    @MethodSource("boardAndExpectedWinnerProvider")
    public void checkWins(Board board, Mark expected) {
        Assertions.assertFalse(board.getWinningConfiguration(expected).isEmpty());
    }

    @ParameterizedTest
    @MethodSource("boardAndExpectedLoserProvider")
    public void checkDoesNotWin(Board board, Mark mark) {
        Assertions.assertTrue(board.getWinningConfiguration(mark).isEmpty());
    }

}