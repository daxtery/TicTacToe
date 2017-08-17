package game;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.util.ArrayList;

public final class TicTacToe {

    //WINDOW

    private final JFrame GAME_FRAME = new JFrame("Tic-Tac-Toe");
    private final TilePainter PAINTER = new TilePainter(this);
    private final ClickHandler CLICK_HANDLER = new ClickHandler(this);
    private final int WIDTH = 600;
    private final int HEIGHT = 600;
    private final Dimension FRAME_DIM = new Dimension(WIDTH, HEIGHT);
    final static int FONT_SIZE = 70;
    final static int BORDER = 60;
    private static JMenuBar menuBar;
    private static JMenu newGame;

    //GAME STUFF
    private int oWins = 0;
    private int xWins = 0;
    private Owner currentPlayer = Owner.X;

    private static ArrayList<int[]> possible_wins;

    //TILES
    private final int COLUMNS = 3;
    private final int LINES = 3;
    private Tile[] tileArray = new Tile[COLUMNS*LINES];

    public static void main(String[] args){
        TicTacToe t = new TicTacToe();
        //t.newGame();
    }

    private void waysToWin(){
        possible_wins = new ArrayList<>();
        //xxx
        //
        //
        possible_wins.add(new int[]{
                1,0,0,1,0,0,1,0,0
        });
        //
        //xxx
        //
        possible_wins.add(new int[]{
                0,1,0,0,1,0,0,1,0
        });
        //
        //
        //xxx
        possible_wins.add(new int[]{
                0,0,1,0,0,1,0,0,1
        });
        //x
        //x
        //x
        possible_wins.add(new int[]{
                1,1,1,0,0,0,0,0,0
        });
        // x
        // x
        // x
        possible_wins.add(new int[]{
                0,0,0,1,1,1,0,0,0
        });
        //  x
        //  x
        //  x
        possible_wins.add(new int[]{
                0,0,0,0,0,0,1,1,1
        });
        //x
        // x
        //  x
        possible_wins.add(new int[]{
                1,0,0,0,1,0,0,0,1
        });
        //  x
        // x
        //x
        possible_wins.add(new int[]{
                0,0,1,0,1,0,1,0,0
        });

    }

    private TicTacToe(){
        waysToWin();
        doTiles();
        buildFrame();
    }

    private void newGame() {
        resetTiles();
        GAME_FRAME.repaint();
    }

    private void doTiles(){
        int i = 0; //array index
        for(int x = 0; x < COLUMNS ; x++){
            for(int y = 0; y < LINES; y++){
                tileArray[i] = new Tile(Tile.WIDTH * x, Tile.HEIGHT * y, this);
//                if(i == 4){
//                    tileArray[i].capture(Owner.X);
//                }
//                if(i == 0){
//                    tileArray[i].capture(Owner.O);
//                }
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

        menuBar = new JMenuBar();
        newGame = new JMenu("Start new game");
        newGame.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                newGame();
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });
        menuBar.add(newGame);

        GAME_FRAME.addMouseListener(CLICK_HANDLER);
        GAME_FRAME.setSize(FRAME_DIM);
        GAME_FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GAME_FRAME.setResizable(false);
        GAME_FRAME.setMinimumSize(FRAME_DIM);
        GAME_FRAME.setMaximumSize(FRAME_DIM);
        GAME_FRAME.add(PAINTER);
        GAME_FRAME.setVisible(true);
        GAME_FRAME.setJMenuBar(menuBar);
        GAME_FRAME.pack(); // Pack all the changes.

    }

    private void claim(int index){
        tileArray[index].capture(currentPlayer);
        GAME_FRAME.repaint();
        if(won(currentPlayer)){
            sendWin(currentPlayer);
            return;
        }
        if(allFull()){
            //draw
            sendDraw();
        }
        nextTurn();
    }

    void attemptClaim(int x, int y) {
        boolean withinBounds = checkBounds(x, y);
        if(withinBounds && !allFull()){
            int theX = (x - 60)/Tile.WIDTH;
            int theY = (y - 60)/Tile.HEIGHT;
            int theIndex = theX*3 + theY;
            claim(theIndex);
        }
    }

    private void sendWin(Owner currentPlayer) {
        if(currentPlayer == Owner.O){
            oWins++;
        }
        else{
            xWins++;
        }
        String message = String.format("%s won the game! Score is: X - %d vs O - %d",
                currentPlayer, xWins, oWins);
        JOptionPane.showMessageDialog(GAME_FRAME,message);
        newGame();
    }

    private boolean won(Owner currentPlayer) {
        System.out.println();
        System.out.println("NEW MOVE");
        int[] captures = capturedTilesFor(currentPlayer);
        for(int[] way : possible_wins){
            if(winningArray(captures, way)){
                return true;
            }
        }
        return false;
    }

    private boolean winningArray(int[]have, int[]need){
        System.out.println();
        System.out.println("NEW ARRAY");
        for(int i = 0; i < have.length; i++){
            int hav = have[i];
            int ned = need[i];
            System.out.println("Board: " + hav + " == " + "Needed: " + ned );
            if(ned == 1 && hav == 0){
                return false;
            }
        }
        return true;
    }

    private int[] capturedTilesFor(Owner player){
        int[] captures = new int[COLUMNS*LINES];
        int i = 0;
        for(Tile t : tileArray){
            if(t.getOwner() == player){
                captures[i] = 1;
            }
            i++;
        }
//        for (int ii : captures){
//            System.out.println(ii);
//        }
        return captures;
    }

    private void sendDraw() {
        String message = String.format("It\'s a Draw! Score is: X - %d vs O - %d", xWins, oWins);
        JOptionPane.showMessageDialog(GAME_FRAME, message);
    }

    private boolean allFull() {
        for (Tile t : tileArray){
            if(!t.isCaptured()){
                return false;
            }
        }
        return true;
    }

    private void nextTurn(){
        currentPlayer = currentPlayer.getOpposite();
    }

    private boolean checkBounds(int x, int y) {
        return (x >= BORDER && y >= BORDER) &&(x <= Tile.WIDTH * COLUMNS + BORDER && y <= Tile.HEIGHT*LINES + BORDER);
    }
}
