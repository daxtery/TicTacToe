import java.awt.Color;
import models.Type;

/**
 * OwnerHelper
 */
final class OwnerHelper {

    static String GetText(final Type owner) {
        switch (owner) {
        case X:
            return "X";
        case O:
            return "O";
        default:
            return " ";
        }
    }

    static Color getColor(final Type owner) {
        switch (owner) {
        // case X:
        // return Color.LIGHT_GRAY;
        // case O:
        // return Color.DARK_GRAY;
        default:
            return Color.WHITE;
        }
    }

    static Color getTextColor(final Type owner) {
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