package board;

import pieces.Piece;

public class Move {
    private String oldPosition;
    private String newPosition;
    private boolean take;
    private Piece piece;

    public Move(Piece piece, String oldPos, boolean take) {
        this.piece = piece;
        this.oldPosition = oldPos;
        this.newPosition = piece.getChessPosition();
        this.take = take;
    }

    public String toString() {
        // Returns the move in Long Algebraic Notation

        String output = "";

        if (piece.getSymbol() != ' ')
            output += piece.getSymbol();

        output += oldPosition;

        if (take)
            output += "x";
        else
            output += "-";

        output += newPosition;

        return output;
    }

    public String toChessNotation() {
        String output = "";
        if (piece.getSymbol() != ' ')
            output += piece.getSymbol();

        return output + newPosition;
    }
}
