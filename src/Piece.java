public abstract class Piece {
    private static final Character[] LETTERS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    protected final boolean white;
    private final char symbol;
    protected Position position;

    public Piece(char symbol, boolean white, Position pos) {
        this.symbol = symbol;
        this.white = white;
        this.position = pos;
    }

    public boolean move(int dx, int dy) {
        if (!(position.isValid(dx, dy))
            || ((dx == 0) && (dy == 0)))
            return false;

        position.x += dx;
        position.y += dy;
        return true;
    }

    public static Piece getPiece(char symbol, boolean white, Position position) {
        if (symbol == 'K')
            return new King(white, position);
        else if (symbol == 'N')
            return new Knight(white, position);
        else if (symbol == 'B')
            return new Bishop(white, position);
        else if (symbol == 'R')
            return new Rook(white, position);
        else if (symbol == 'Q')
            return new Queen(white, position);
        else if (symbol == ' ')
            return new Pawn(white, position);

        return null;
    }

    public String toString() {
        String output = "";
        if (symbol != ' ')
            output += Character.toString(symbol);

        output += this.chessPosition();

        return output;
    }

    public char getSymbol() {
        return symbol;
    }

    public Position getPosition() {
        return this.position;
    }

    public String chessPosition() {
        return LETTERS[position.x-1] + Integer.toString(LETTERS.length - position.y+1);
    }
}
