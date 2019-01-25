package daxtery.logic;

public enum Player {
    X, O, E;

    public Player getOpposite() {
        switch (this) {
        case X:
            return Player.O;
        case O:
            return Player.X;
        default:
            return Player.E;
        }
    }
}