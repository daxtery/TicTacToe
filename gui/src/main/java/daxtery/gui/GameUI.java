package daxtery.gui;

import daxtery.logic.Player;
import javafx.scene.paint.Color;

public final class GameUI {

    public static final Color TILE_STROKE_COLOR = Color.BLACK;

    private GameUI() {
    }

    public static String getText(final Player player) {
        switch (player) {
        case X:
            return "X";
        case O:
            return "O";
        default:
            return " ";
        }
    }

    public static Color getTextColor(final Player player) {
        switch (player) {
        case X:
            return Color.BLACK;
        case O:
            return Color.DARKGRAY;
        default:
            return Color.MAGENTA;
        }
    }

}