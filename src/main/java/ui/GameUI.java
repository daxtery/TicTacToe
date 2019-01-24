package ui;

import javafx.scene.paint.Color;
import models.Player;
import models.Board;

public final class GameUI {

    public static final int PREFERED_WIDTH = 1920;
    public static final int PREFERED_HEIGHT = 1080;

    public static final int TILE_WIDTH = PREFERED_WIDTH / Board.LINES;
    public static final int TILE_HEIGHT = PREFERED_HEIGHT / Board.COLUMNS - 30;
    public static final int TILE_FONT_SIZE = (int) (TILE_HEIGHT - TILE_HEIGHT / 10);

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