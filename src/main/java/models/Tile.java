package models;

public final class Tile {

    private Type owner = Type.EMPTY;

    public Tile() {
    }

    public boolean isCaptured() {
        return owner != Type.EMPTY;
    }

    public void set(Type newOwner) {

        if (isCaptured()) {
            System.err.println(this + "is already occupied by " + owner);
            return;
        }

        owner = newOwner;
    }

    public Type getOwner() {
        return owner;
    }

    void reset() {
        owner = Type.EMPTY;
    }

}
