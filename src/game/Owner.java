package game;

import java.awt.*;

public enum Owner {
    X,
    O,
    NEUTRAL;

    public String getText() {
        switch (this) {
            case X:
                return "X";
            case O:
                return "O";
            default:
                return " ";
        }
    }

    public Owner getOpposite() { // Get the opposite of this Enum. If it was X, then the opposite is O, and likewise.
        switch (this) {
            case X:
                return O;
            case O:
                return X;
            default:
                return NEUTRAL;
        }
    }

    public Color getColor() { // Get the background color to color the Tile.
        switch (this) {
//            case X:
//                return Color.LIGHT_GRAY;
//            case O:
//                return Color.DARK_GRAY;
            default:
                return Color.WHITE;
        }
    }

    public Color getTextColor() { // Get the color to make the text of the Tile.
        switch (this) {
            case X:
                return Color.BLACK;
            case O:
                return Color.DARK_GRAY;
            default:
                return Color.MAGENTA;
        }
    }
}
