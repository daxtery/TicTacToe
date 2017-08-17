package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public final class ClickHandler implements MouseListener{

    private final TicTacToe game;

    public ClickHandler(TicTacToe _game) {
        game = _game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("x: " + e.getX());
        System.out.println("y: " + e.getY());
        game.attemptClaim(e.getX() - 3, e.getY() - 50); // Subtracts from the values to eliminate interference from the frame border.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        /* TODO mouse */
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
