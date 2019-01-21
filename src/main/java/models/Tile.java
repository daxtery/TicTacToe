package models;

public final class Tile {

    private Type type;

    public Tile() {
        this(Type.E);
    }

    public Tile(Type type) {
        this.type = type;
    }

    public boolean isCaptured() {
        return type != Type.E;
    }

    public void setType(Type newtype) {
        type = newtype;
    }

    public Type getType() {
        return type;
    }

}
