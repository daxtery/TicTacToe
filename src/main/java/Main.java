import java.util.Scanner;

import logic.AI;
import models.Board;
import models.Player;

/**
 * Main
 */
public class Main {

    static Player current = Player.O;
    static Board board;

    public static void main(String[] args) {
        board = new Board();
        play();
    }

    static void play() {

        Scanner scanner = new Scanner(System.in);

        while (!board.allFull()) {
            int j = AI.getBestMove(board, current);
            board.set(j, current);
            current = current.getOpposite();
            System.out.println(board);
            int index = scanner.nextInt();
            board.set(index, current);
            current = current.getOpposite();
        }

        scanner.close();
    }

}