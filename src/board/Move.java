package board;

import pieces.Piece;

public class Move {
    private String oldPosition;
    private String newPosition;
    private Piece piece;

    public Move(Piece piece, String oldPos, String newPos) {
        this.piece = piece;
        this.oldPosition = oldPos;
        this.newPosition = newPos;
    }

    public String toString() {
        return piece.getClass().toString() + " moved from " + oldPosition + " to " + newPosition;
    }

    public String toChessNotation() {
        String output = "";
        if (piece.getSymbol() != ' ')
            output += piece.getSymbol();

        return output + newPosition;
    }
}
