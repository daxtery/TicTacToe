package daxtery.logic;

public enum Mark {
    X, O;

    public Mark getOpposite() {
        return switch (this) {
            case X -> Mark.O;
            case O -> Mark.X;
        };
    }
}