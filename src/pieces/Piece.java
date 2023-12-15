package pieces;

import board.Position;

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
        if (!(isValidMove(dx, dy)))
            return false;

        position.x += dx;
        position.y += dy;

        return true;
    }

    public boolean take(int dx, int dy) {
        return move(dx, dy);
    }
    public abstract Position[] intermediatesForMove(int dx, int dy);

    public boolean isValidMove(int dx, int dy) {
        return position.isValid(dx, dy)
                    || ((dx == 0) && (dy == 0));
    }

    public String toString() {
        String output = "";
        if (symbol != ' ')
            output += Character.toString(symbol);

        output += this.getChessPosition();

        return output;
    }

    public char getSymbol() {
        return symbol;
    }
    public char getSide() {
        if (white) return 'w';
        return 'b';
    }
    public Position getIntPosition() {
        return this.position;
    }
    public String getChessPosition() {
        return LETTERS[position.x-1] + Integer.toString(LETTERS.length - position.y+1);
    }
    public boolean isWhite() {
        return white;
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
    public static String toChessPosition(Position pos) {
        return LETTERS[pos.x-1] +Integer.toString(LETTERS.length - pos.y + 1);
    }
    public static Position toIntPosition(String chessPosition) {
        char[] characters = chessPosition.toCharArray();
        Position position;
        char x, y;

        if (characters.length == 2) {
            x = characters[0];
            y = characters[1];
        } else if (characters.length == 3) {
            x = characters[1];
            y = characters[2];
        } else {
            return null;
        }
        position = new Position(
                findInLetters(x)+1,
                LETTERS.length - Integer.parseInt(Character.toString(y)) + 1);

        if (position.isValid())
            return position;
        return null;
    }
    private static int findInLetters(char letter) {
        int index = -1;
        for (int i = 0; i < LETTERS.length; i++) {
            if (letter == LETTERS[i])
                index = i;
        }

        return index;
    }
}
