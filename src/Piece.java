public class Piece {
    boolean white;
    String name;

    public Piece(String name, boolean white) {
        this.name = name;
        this.white = white;
    }

    public String toString() {
        return name;
    }
}
