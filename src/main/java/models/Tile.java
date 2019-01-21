package models;

public final class Tile {

    private Player type;

    public Tile() {
        this(Player.E);
    }

    public Tile(Player type) {
        this.type = type;
    }

    public boolean isCaptured() {
        return type != Player.E;
    }

    public void setPlayer(Player newtype) {
        type = newtype;
    }

    public Player getPlayer() {
        return type;
    }

}
