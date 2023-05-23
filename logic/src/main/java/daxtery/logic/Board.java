package daxtery.logic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Board {

    public static final int COLUMNS = 3;
    public static final int LINES = 3;
    public static final int SIZE = COLUMNS * LINES;
    private final Mark[] marks;

    public Board() {
        marks = new Mark[COLUMNS * LINES];
    }

    public Optional<Mark> get(int index) {
        return Optional.ofNullable(marks[index]);
    }


    public List<Integer> getWinningConfiguration(Mark currentMark) {
        var configurations = Stream.of(allDiagonalConfigurations(), allVerticalConfigurations(), allHorizontalConfigurations()).flatMap(Function.identity());
        return configurations.map(IntStream::toArray).filter(indexes -> checkWin(indexes, currentMark)).findFirst().map(t -> Arrays.stream(t).boxed().toList()).orElse(List.of());
    }

    private boolean checkWin(int[] indexes, Mark mark) {
        return Arrays.stream(indexes).allMatch(i -> marks[i] != null && marks[i] == mark);
    }

    public void set(int index, Mark mark) {
        marks[index] = mark;
    }

    public boolean allFull() {
        for (Mark mark : marks) {
            if (mark == null) return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            s.append(marks[i] == null ? "?" : marks[i].toString());
            if ((i + 1) % COLUMNS == 0) {
                s.append("\n ");
            } else {
                s.append(" ");
            }
        }
        return s.toString();
    }

    public void reset() {
        Arrays.fill(marks, null);
    }

    private Stream<IntStream> allDiagonalConfigurations() {
        return Stream.of(mainDiagonalConfiguration(), secondaryDiagonalConfiguration());
    }

    private IntStream secondaryDiagonalConfiguration() {
        var builder = IntStream.builder();

        for (int i = COLUMNS - 1; i < (COLUMNS * LINES) - 1; i += COLUMNS - 1) {
            builder.add(i);
        }

        return builder.build();
    }

    private IntStream mainDiagonalConfiguration() {
        var builder = IntStream.builder();

        for (int i = 0; i < COLUMNS * LINES; i += COLUMNS + 1) {
            builder.add(i);
        }

        return builder.build();
    }

    private Stream<IntStream> allVerticalConfigurations() {
        var builder = Stream.<IntStream>builder();

        for (int i = 0; i < LINES; i++) {
            builder.add(verticalConfiguration(i));
        }

        return builder.build();
    }

    private IntStream verticalConfiguration(int line) {
        var builder = IntStream.builder();

        for (int j = 0; j < COLUMNS; j++) {
            int index = line * COLUMNS + j;
            builder.add(index);
        }

        return builder.build();
    }

    private Stream<IntStream> allHorizontalConfigurations() {
        var builder = Stream.<IntStream>builder();

        for (int i = 0; i < COLUMNS; i++) {
            builder.add(horizontalConfiguration(i));
        }

        return builder.build();
    }

    private IntStream horizontalConfiguration(int column) {
        var builder = IntStream.builder();

        for (int j = 0; j < LINES; j++) {
            int index = j * LINES + column;
            builder.add(index);
        }

        return builder.build();
    }
}
