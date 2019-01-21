// import java.awt.Dimension;
// import java.awt.Font;
// import java.util.ArrayList;
// import java.util.Random;

// import javax.swing.JFrame;
// import javax.swing.JMenu;
// import javax.swing.JMenuBar;
// import javax.swing.JOptionPane;
// import javax.swing.UIManager;
// import javax.swing.WindowConstants;
// import javax.swing.event.MenuEvent;
// import javax.swing.event.MenuListener;

// import models.Type;

// // WINDOW
 

// private final TilePainter PAINTER = new TilePainter(this);
// private final ClickHandler CLICK_HANDLER = new ClickHandler(this);
// private final int WIDTH = 600;
// private final int HEIGHT = 600;
// ate final Dimension FRAME_DIM = new Dimension(WIDTH, HEIGHT);
// final static int FONT_SIZE = 70;
//     final static int BORDER = 60;
// ate static JMenuBar menuBar;
// private static JMenu newGame;
// private static JMenu vsAI;

// AME STUFF

//     private int p1Wins = 0;
  

// private int playerTurn = 0;
 


// private static final String pcName = "PC";

// ate static ArrayList<int[]> possible_wins;
 

// private final int COLUMNS = 3;

// private Tile[] tileArray = new Tile[COLUMNS * LINES];
 

// 

// private String p1;
// 

// ate static final String[] tempNames = new String[] { "John", "Mike", "Kate", "Got no name" };
  
// 

//         // TicTacToe t = new TicTacToe();
// 

// 
 

// possible_wins = new ArrayList<>();
// // xxx
// //
// //
// possible_wins.add(new int[] { 1, 0, 0, 1, 0, 0, 1, 0, 0 });
// //
// // xxx
// //
// possible_wins.add(new int[] { 0, 1, 0, 0, 1, 0, 0, 1, 0 });
// //
// //
// // xxx
// possible_wins.add(new int[] { 0, 0, 1, 0, 0, 1, 0, 0, 1 });
// // x
// // x
// // x
// possible_wins.add(new int[] { 1, 1, 1, 0, 0, 0, 0, 0, 0 });
// // x
// // x
// // x
// possible_wins.add(new int[] { 0, 0, 0, 1, 1, 1, 0, 0, 0 });
// // x
// // x
// // x
// possible_wins.add(new int[] { 0, 0, 0, 0, 0, 0, 1, 1, 1 });
// // x
// // x
// 
//
// // x
// // x

//

// 
 

// ame = JOptionPane.showInputDialog(q);
// if (tempName == null || tempName.equalsIgnoreCase("")) {
//            tempName = tempNames[new Random().nextInt(tempNames.length)];
// 

// 
 

// kPlayerName("Player 1's name?");
// p2 = askPlayerName("Player 2's name?");
//        waysToWin();
// 

// }
 

// p1 = askPlayerName("Player 1's name?");
// = "PC";
// in();
// doTiles();
//        buildFrame();
// 

// 
 

// resetTiles();
//
// theAI.play();
// 
//
//  0;
//    p2Wins = 0;
//         p2 = "PC";
// 

// 
 

// 2.equalsIgnoreCase(pcName)) {
// ns = 0;
// ns = 0;
//     p2 = askPlayerName("Player 2's name?");
//     }
// 

// 
 

// 0; // array index
//  x = 0; x < COLUMNS; x++) {
// int y = 0; y < LINES; y++) {
// tileArray[i] = new Tile(Tile.WIDTH * x, Tile.HEIGHT * y, this);
// // if(i == 4){
// ileArray[i].capture(Owner.X);
// 
//
// rray[i].capture(Owner.O);
//     // }
//             i++;
// 
// 
// }

//

// 
  

//

// 

// ate void buildFrame() {
 

// = new JMenu("Start new game");
// ner(new MenuListener() {
// rride
//         public void menuSelected(MenuEvent e) {
//  false;
// newGame();
// 

// @

// 
  

//             public void menuCanceled(MenuEvent e) {
// 
 
// Bar.add(newGame);
 

// (new MenuListener() {
// rride
//         public void menuSelected(MenuEvent e) {
//  true;
// newAIGame();
// 

// @

// 
  

//             public void menuCanceled(MenuEvent e) {
// 
 
// menuBar.add(vsAI);
 

// GAME_FRAME.setSize(FRAME_DIM);
// GAME_FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
// GAME_FRAME.setResizable(false);
// GAME_FRAME.setMinimumSize(FRAME_DIM);
// GAME_FRAME.setMaximumSize(FRAME_DIM);
// ME.add(PAINTER);
// _FRAME.setVisible(true);
// GAME_FRAME.setJMenuBar(menuBar);
// GAME_FRAME.pack(); // Pack all the changes.

//

// 
 

// changeTurn = false;
// if (!tileArray[index].isCaptured()) {
//     tileArray[index].capture(currentPlayer);
// _FRAME.repaint();
// changeTurn = true;
// }
// if (won(currentPlayer)) {
//
// return;
// 
//
// // draw
// Draw();
// rn;
// 
//
// 

// 
 

// withinBounds = checkBounds(x, y);
// unds && !allFull()) {
//  = (x - 60) / Tile.WIDTH;
// nt theY = (y - 60) / Tile.HEIGHT;
//             int theIndex = theX * 3 + theY;
// 

// 
  

// if (playerTurn == 0) {
//             return p1;
// 

// 
 

// 
//
// 
//
//
// 
//
//
//     p1Wins, p2, p2Wins);  
// 
// showMessageDialog(GAME_FRAME, message);
// 
//
//         return;
// 

// 
 

// ystem.out.println();
// m.out.println("NEW MOVE");
// ptures = capturedTilesFor(currentPlayer);
// ay : possible_wins) {
// ingArray(captures, way)) {
//         return true;
//     }
// 

// 
 

// ystem.out.println();
// ystem.out.println("NEW ARRAY");
// (int i = 0; i < have.length; i++) {
// = have[i];
// ned = need[i];
// m.out.println("Board: " + hav + " == " + "Needed: " + ned );
// == 1 && hav == 0) {
//         return false;
//     }
// 

// 
 

// ptures = new int[COLUMNS * LINES];
// 0;
// : tileArray) {
// if (t.getOwner() == player) {
//     captures[i] = 1;
// }
// 
// 
//
//         // Syste
// 
//

// 
  

//
// ng message = String.format("It\'s a Draw! Score is: \n%s  ==> %d \n%s  ==> %d", p1, p1Wins, p2, p2Wins);
// ane.showMessageDialog(GAME_FRAME, message);  
// 
// 
//
//         return;
// 

// 
 

// : tileArray) {
// sCaptured()) {
//         return false;
//     }
// 

// 
 

// r = Type.O;
// playerTurn == 0) {
// erTurn++;
// {
// theAI.play();
// }
//         } else {
// 
// }
// 
//
 

//
//         return (x > BORDER && y > BORDER) && (x < Tile.WIDTH * COLUMNS + BORDER && y < Tile.HEIGHT * LINES + BORDER);
// 
// 
// 
