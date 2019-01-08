package models;

public enum Type {
    X, O, EMPTY;

    Type GetOpposite() {
        switch (this) {
        case X:
            return Type.O;
        case O:
            return Type.X;
        default:
            return Type.EMPTY;
        }
    }
}