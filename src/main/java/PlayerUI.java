import java.awt.Color;
import models.Player;

/**
 * OwnerHelper
 */
public final class PlayerUI {

    static String getText(final Player player) {
        switch (player) {
        case X:
            return "X";
        case O:
            return "O";
        default:
            return " ";
        }
    }

    static Color getColor(final Player player) {
        switch (player) {
        // case X:
        // return Color.LIGHT_GRAY;
        // case O:
        // return Color.DARK_GRAY;
        default:
            return Color.WHITE;
        }
    }

    static Color getTextColor(final Player player) {
        switch (player) {
        case X:
            return Color.BLACK;
        case O:
            return Color.DARK_GRAY;
        default:
            return Color.MAGENTA;
        }
    }

    private PlayerUI() {

    }

}