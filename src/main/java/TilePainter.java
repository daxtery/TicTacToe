import java.awt.*;

public final class TilePainter extends Component {

    private final TicTacToe game;

    TilePainter(TicTacToe _game) {
        game = _game;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // ANTIALIASING
        g2d.setFont(new Font("Dialogue", Font.BOLD, TicTacToe.FONT_SIZE));
        for (Tile t : game.getTiles()) {
            g.setColor(Color.BLACK);
            g.drawRect(t.getX() - 1, t.getY() - 1, Tile.WIDTH + 1, Tile.HEIGHT + 1);
            t.paint(g2d);
        }
    }

}
