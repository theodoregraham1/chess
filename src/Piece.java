public abstract class Piece {
    private static final Character[] LETTERS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    private final boolean white;
    private final char symbol;
    protected Position position;

    public Piece(char symbol, boolean white, Position pos) {
        this.symbol = symbol;
        this.white = white;
        this.position = pos;
    }

    public abstract boolean move(int dx, int dy);

    public static Piece getPiece(char symbol, boolean white, Position position) {
        if (symbol == 'K')
            return new King(white, position);
        else if (symbol == 'N')
            return new Knight(white, position);
        else if (symbol == 'B')

        return null;
    }

    public String toString() {
        String output = "";
        if (symbol != ' ')
            output += Character.toString(symbol);

        output += LETTERS[position.x] + (LETTERS.length - position.y);

        return output;
    }
}
