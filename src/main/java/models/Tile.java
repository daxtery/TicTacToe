package models;

public final class Tile {

    private Type type;

    public Tile() {
        this(Type.EMPTY);
    }

    public Tile(Type type) {
        this.type = type;
    }

    public boolean isCaptured() {
        return type != Type.EMPTY;
    }

    public void setType(Type newtype) {
        type = newtype;
    }

    public Type getType() {
        return type;
    }

    void resetType() {
        type = Type.EMPTY;
    }

}
