// import java.awt.*;

// import models.Type;

// public final class Tile {

// private int x;
// private int y;

// static final int WIDTH = 120;
// static final int HEIGHT = 120;

// private Type owner = Type.EMPTY;
// private boolean captured = false;

// Tile(int _x, int _y, Game _game) {
// x = _x + Game.BORDER;
// y = _y + Game.BORDER;
// }

// public boolean isCaptured() {
// return captured;
// }

// public void capture(Type newOwner) {
// if (!captured && owner == Type.EMPTY) {
// captured = true;
// owner = newOwner;
// }
// }

// public Type getOwner() {
// return owner;
// }

// void paint(Graphics g) {
// // System.out.printf("Drawing a tile at x:%d y:%d \nThe owner is %s and it's
// // color is %s\n", getX(), getY(), getOwner().name(),
// // getOwner().getColor().toString());
// g.setColor(OwnerHelper.getColor(owner));
// g.fillRect(x, y, WIDTH, HEIGHT);
// g.setColor(OwnerHelper.getTextColor(owner));
// int calcX = (x + WIDTH / 2) - (Game.FONT_SIZE / 3);
// int calcY = (y + HEIGHT / 2) + (Game.FONT_SIZE / 3);
// g.drawString(OwnerHelper.GetText(owner), calcX, calcY);
// }

// void reset() { // Used to reset this Tile after the game is over.
// owner = Type.EMPTY;
// captured = false;
// }

// int getX() {
// return x;
// }

// int getY() {
// return y;
// }
// }
