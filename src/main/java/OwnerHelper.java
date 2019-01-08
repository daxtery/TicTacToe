import java.awt.Color;

/**
 * OwnerHelper
 */
final class OwnerHelper {

    static String GetText(final Owner owner) {
        switch (owner) {
        case X:
            return "X";
        case O:
            return "O";
        default:
            return " ";
        }
    }

    static Color getColor(final Owner owner) {
        switch (owner) {
        // case X:
        // return Color.LIGHT_GRAY;
        // case O:
        // return Color.DARK_GRAY;
        default:
            return Color.WHITE;
        }
    }

    static Color getTextColor(final Owner owner) {
        switch (owner) {
        case X:
            return Color.BLACK;
        case O:
            return Color.DARK_GRAY;
        default:
            return Color.MAGENTA;
        }
    }

    private OwnerHelper() {

    }

}