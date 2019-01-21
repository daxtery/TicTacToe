package models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {

    TicTacToe tacToe;

    @Before
    public void setup() {
        tacToe = new TicTacToe();
    }

    @Test
    public void Owins111000000() {
        tacToe.set(0, Player.O);
        tacToe.set(1, Player.O);
        tacToe.set(2, Player.O);
        assertTrue(tacToe.won(Player.O));
    }

    @Test
    public void Odoesntwin101000000() {
        tacToe.set(0, Player.O);
        tacToe.set(1, Player.X);
        tacToe.set(2, Player.O);
        assertFalse(tacToe.won(Player.O));
    }

    @Test
    public void Owins000111000() {
        tacToe.set(3, Player.O);
        tacToe.set(4, Player.O);
        tacToe.set(5, Player.O);
        assertTrue(tacToe.won(Player.O));
    }

    @Test
    public void Owins000000111() {
        tacToe.set(6, Player.O);
        tacToe.set(7, Player.O);
        tacToe.set(8, Player.O);
        assertTrue(tacToe.won(Player.O));
    }

    @Test
    public void Odoesntwin000001011() {
        tacToe.set(5, Player.O);
        tacToe.set(7, Player.O);
        tacToe.set(8, Player.O);
        assertFalse(tacToe.won(Player.O));
    }

    @Test
    public void Xdoesntwin000001011() {
        tacToe.set(5, Player.X);
        tacToe.set(7, Player.X);
        tacToe.set(8, Player.X);
        assertFalse(tacToe.won(Player.X));
    }

    @Test
    public void XdoesntwinXOXOXOOXO() {
        tacToe.set(0, Player.X);
        tacToe.set(1, Player.O);
        tacToe.set(2, Player.X);
        tacToe.set(3, Player.O);
        tacToe.set(4, Player.X);
        tacToe.set(5, Player.O);
        tacToe.set(6, Player.O);
        tacToe.set(7, Player.X);
        tacToe.set(8, Player.O);
        assertFalse(tacToe.won(Player.X));
    }

    @Test
    public void OdoesntwinXOXOXOOXO() {
        tacToe.set(0, Player.X);
        tacToe.set(1, Player.O);
        tacToe.set(2, Player.X);
        tacToe.set(3, Player.O);
        tacToe.set(4, Player.X);
        tacToe.set(5, Player.O);
        tacToe.set(6, Player.O);
        tacToe.set(7, Player.X);
        tacToe.set(8, Player.O);
        assertFalse(tacToe.won(Player.O));
    }

    @Test
    public void OwinsOOXOXOOXO() {
        tacToe.set(0, Player.O);
        tacToe.set(1, Player.O);
        tacToe.set(2, Player.X);
        tacToe.set(3, Player.O);
        tacToe.set(4, Player.X);
        tacToe.set(5, Player.O);
        tacToe.set(6, Player.O);
        tacToe.set(7, Player.X);
        tacToe.set(8, Player.O);
        assertTrue(tacToe.won(Player.O));
    }

    @Test
    public void OwinsOXOXOXO() {
        tacToe.set(0, Player.O);
        tacToe.set(1, Player.X);
        tacToe.set(2, Player.O);
        tacToe.set(3, Player.X);
        tacToe.set(4, Player.O);
        tacToe.set(5, Player.X);
        tacToe.set(6, Player.O);
        assertTrue(tacToe.won(Player.O));
    }

}