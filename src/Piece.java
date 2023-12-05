public class Piece {
    private boolean white;
    private final char symbol;
    protected int[] position;

    public Piece(char symbol, boolean white, int[] pos) {
        this.symbol = symbol;
        this.white = white;
        this.position = pos.clone();
    }

    public String toString() {
        if (symbol != ' ')
            return Character.toString(symbol);
        else
            return "p";
    }
}
