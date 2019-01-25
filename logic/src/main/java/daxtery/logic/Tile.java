package daxtery.logic;

public final class Tile {

    private Player type;

    public Tile() {
        type = Player.E;
    }

    boolean isFree() {
        return type == Player.E;
    }

    void setPlayer(Player newtype) {
        type = newtype;
    }

    Player getPlayer() {
        return type;
    }

    void reset() {
        this.type = Player.E;
    }

    public boolean isCaptured() {
        return false;
    }

}
