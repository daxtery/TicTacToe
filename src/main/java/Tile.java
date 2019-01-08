import java.awt.*;

public final class Tile {

    private int x;
    private int y;

    static final int WIDTH = 120;
    static final int HEIGHT = 120;

    private Owner owner = Owner.EMPTY;
    private boolean captured = false;

    Tile(int _x, int _y, TicTacToe _game) {
        x = _x + TicTacToe.BORDER;
        y = _y + TicTacToe.BORDER;
    }

    public boolean isCaptured() {
        return captured;
    }

    public void capture(Owner newOwner) {
        if (!captured && owner == Owner.EMPTY) {
            captured = true;
            owner = newOwner;
        }
    }

    public Owner getOwner() {
        return owner;
    }

    void paint(Graphics g) {
        // System.out.printf("Drawing a tile at x:%d y:%d \nThe owner is %s and it's
        // color is %s\n", getX(), getY(), getOwner().name(),
        // getOwner().getColor().toString());
        g.setColor(OwnerHelper.getColor(owner));
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(OwnerHelper.getTextColor(owner));
        int calcX = (x + WIDTH / 2) - (TicTacToe.FONT_SIZE / 3);
        int calcY = (y + HEIGHT / 2) + (TicTacToe.FONT_SIZE / 3);
        g.drawString(OwnerHelper.GetText(owner), calcX, calcY);
    }

    void reset() { // Used to reset this Tile after the game is over.
        owner = Owner.EMPTY;
        captured = false;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
