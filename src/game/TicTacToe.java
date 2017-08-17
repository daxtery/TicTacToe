package game;

import javax.swing.*;
import java.awt.*;

public final class TicTacToe {

    //WINDOW

    private final JFrame GAME_FRAME = new JFrame("Tic-Tac-Toe");
    private final TilePainter PAINTER = new TilePainter(this);
    private final ClickHandler CLICK_HANDLER = new ClickHandler(this);
    private int whoseTurn = 0;
    private final int WIDTH = 600;
    private final int HEIGHT = 600;
    private final Dimension FRAME_DIM = new Dimension(WIDTH, HEIGHT);
    final static int FONT_SIZE = 70;
    final static int BORDER = 60;
    private JFrame outcome = new JFrame(); // Outcome frame. This will be shown whenever a player wins, or a draw occurs.

    //GAME STUFF
    private int oWins = 0;
    private int xWins = 0;
    private boolean gameOver = false;
    private boolean nextTurn = false;

    //TILES
    private final int COLUMNS = 3;
    private final int LINES = 3;
    private Tile[] tileArray = new Tile[COLUMNS*LINES];

    public static void main(String[] args){
        TicTacToe t = new TicTacToe();
        //t.newGame();
    }

    public void newGame(){
        resetTiles();
    }

    public TicTacToe(){
        doTiles();
        buildFrame();
    }

    private void doTiles(){
        int i = 0; //array index
        for(int x = 0; x < COLUMNS ; x++){
            for(int y = 0; y < LINES; y++){
                tileArray[i] = new Tile(Tile.WIDTH * x, Tile.HEIGHT * y, this);
                if(i == 4){
                    tileArray[i].capture(Owner.X);
                }
                if(i == 0){
                    tileArray[i].capture(Owner.O);
                }
                i++;
            }
        }
    }


    Tile[] getTiles() {
        return tileArray;
    }

    private void resetTiles() { // Resets the tiles
        for (Tile t : tileArray) // Iterate through all the tiles.
            t.reset(); // Reset each tile.
    }

    private void buildFrame() {
        getGAME_FRAME().addMouseListener(CLICK_HANDLER);
        getGAME_FRAME().setSize(FRAME_DIM);
        getGAME_FRAME().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getGAME_FRAME().setResizable(false);
        getGAME_FRAME().setMinimumSize(FRAME_DIM);
        getGAME_FRAME().setMaximumSize(FRAME_DIM);
        getGAME_FRAME().add(PAINTER);
        getGAME_FRAME().setVisible(true);
        getGAME_FRAME().pack(); // Pack all the changes.
    }

    JFrame getGAME_FRAME() {
        return GAME_FRAME;
    }
}
