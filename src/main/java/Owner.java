import java.awt.*;

class Owner {

    OwnerType ownerType;

    public String getText() {
        switch (ownerType) {
        case X:
            return "X";
        case O:
            return "O";
        default:
            return " ";
        }
    }

    public OwnerType getOpposite() { // Get the opposite of this Enum. If it was X, then the opposite is O, and
        // likewise.
        switch (ownerType) {
        case X:
            return OwnerType.O;
        case O:
            return OwnerType.X;
        default:
            return OwnerType.EMPTY;
        }
    }

    public Color getColor() { // Get the background color to color the Tile.
        switch (ownerType) {
        // case X:
        // return Color.LIGHT_GRAY;
        // case O:
        // return Color.DARK_GRAY;
        default:
            return Color.WHITE;
        }
    }

    public Color getTextColor() { // Get the color to make the text of the Tile.
        switch (ownerType) {
        case X:
            return Color.BLACK;
        case O:
            return Color.DARK_GRAY;
        default:
            return Color.MAGENTA;
        }
    }
}
