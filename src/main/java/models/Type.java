package models;

public enum Type {
    X, O, E;

    public Type getOpposite() {
        switch (this) {
        case X:
            return Type.O;
        case O:
            return Type.X;
        default:
            return Type.E;
        }
    }
}