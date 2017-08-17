package game;

import java.awt.*;

public final class Tile {

    private TicTacToe game;

    private int x;
    private int y;

    static final int WIDTH = 120;
    static final int HEIGHT = 120;

    private Owner owner = Owner.NEUTRAL;
    private boolean captured = false;

    Tile(int _x, int _y, TicTacToe _game) {
        x = _x + TicTacToe.BORDER;
        y = _y + TicTacToe.BORDER;
        game = _game;
    }

    public boolean isCaptured() {
        return captured;
    }

    public void capture(Owner newOwner) {
        if(!captured && owner == Owner.NEUTRAL){
            captured = true;
            owner = newOwner;
        }
    }

    public Owner getOwner() {
        return owner;
    }

    void paint(Graphics g){
        System.out.printf("Drawing a tile at x:%d y:%d \nThe owner is %s and it's color is %s\n", getX(), getY(), getOwner().name(), getOwner().getColor().toString());
        g.setColor(owner.getColor());
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(owner.getTextColor());
        int calcX = (x + WIDTH / 2) - (TicTacToe.FONT_SIZE/3) ;
        int calcY = (y + HEIGHT / 2) + (TicTacToe.FONT_SIZE/3);
        g.drawString(owner.getText(),calcX,calcY);
    }

    void reset() { // Used to reset this Tile after the game is over.
        owner = Owner.NEUTRAL;
        captured = false;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
