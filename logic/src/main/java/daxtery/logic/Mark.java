package daxtery.logic;

public enum Player {
    X, O;

    public Player getOpposite() {
        return switch (this) {
            case X -> Player.O;
            case O -> Player.X;
        };
    }
}