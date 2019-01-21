package models;

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
        tacToe.set(0, Type.O);
        tacToe.set(1, Type.O);
        tacToe.set(2, Type.O);
        assert tacToe.won(Type.O);
    }

    @Test
    public void Odoesntwin101000000() {
        tacToe.set(0, Type.O);
        tacToe.set(1, Type.X);
        tacToe.set(2, Type.O);
        assert !tacToe.won(Type.O);
    }

    @Test
    public void Owins000111000() {
        tacToe.set(3, Type.O);
        tacToe.set(4, Type.O);
        tacToe.set(5, Type.O);
        assert tacToe.won(Type.O);
    }

    @Test
    public void Owins000000111() {
        tacToe.set(6, Type.O);
        tacToe.set(7, Type.O);
        tacToe.set(8, Type.O);
        assert tacToe.won(Type.O);
    }

    @Test
    public void Odoesntwin000001011() {
        tacToe.set(5, Type.O);
        tacToe.set(7, Type.O);
        tacToe.set(8, Type.O);
        assert !tacToe.won(Type.O);
    }

    @Test
    public void Xdoesntwin000001011() {
        tacToe.set(5, Type.X);
        tacToe.set(7, Type.X);
        tacToe.set(8, Type.X);
        assert !tacToe.won(Type.X);
    }

    @Test
    public void XdoesntwinXOXOXOOXO() {
        tacToe.set(0, Type.X);
        tacToe.set(1, Type.O);
        tacToe.set(2, Type.X);
        tacToe.set(3, Type.O);
        tacToe.set(4, Type.X);
        tacToe.set(5, Type.O);
        tacToe.set(6, Type.O);
        tacToe.set(7, Type.X);
        tacToe.set(8, Type.O);
        assert !tacToe.won(Type.X);
    }

    @Test
    public void OdoesntwinXOXOXOOXO() {
        tacToe.set(0, Type.X);
        tacToe.set(1, Type.O);
        tacToe.set(2, Type.X);
        tacToe.set(3, Type.O);
        tacToe.set(4, Type.X);
        tacToe.set(5, Type.O);
        tacToe.set(6, Type.O);
        tacToe.set(7, Type.X);
        tacToe.set(8, Type.O);
        assert !tacToe.won(Type.O);
    }

    @Test
    public void OwinsOOXOXOOXO() {
        tacToe.set(0, Type.O);
        tacToe.set(1, Type.O);
        tacToe.set(2, Type.X);
        tacToe.set(3, Type.O);
        tacToe.set(4, Type.X);
        tacToe.set(5, Type.O);
        tacToe.set(6, Type.O);
        tacToe.set(7, Type.X);
        tacToe.set(8, Type.O);
        assert tacToe.won(Type.O);
    }

    @Test
    public void OwinsOXOXOXO() {
        tacToe.set(0, Type.O);
        tacToe.set(1, Type.X);
        tacToe.set(2, Type.O);
        tacToe.set(3, Type.X);
        tacToe.set(4, Type.O);
        tacToe.set(5, Type.X);
        tacToe.set(6, Type.O);
        assert tacToe.won(Type.O);
    }

}