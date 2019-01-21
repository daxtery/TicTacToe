import logic.AI;
import models.TicTacToe;
import models.Type;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        TicTacToe n = new TicTacToe();
        int j = AI.getBestMove(n, Type.O);
        System.out.println(j);
    }
}