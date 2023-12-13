package board;

import pieces.Pawn;
import pieces.Piece;

import java.util.ArrayList;

public class Chess {
    private static final int SIZE = 8;
    private static final char[] STARTING_BACK_ROW = {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'};

    private final ArrayList<Piece> board;

    public Chess() {
        board = new ArrayList<>();

        // Make black and white back rows and pawns
        for (int i = 1; i < SIZE+1; i++) {
            // Add back rows
            board.add(Piece.getPiece(
                    STARTING_BACK_ROW[i-1],
                    false,
                    new Position(i, 1)));
            board.add(Piece.getPiece(
                    STARTING_BACK_ROW[i-1],
                    true,
                    new Position(i, SIZE)));

            // Add pawns
            board.add(Piece.getPiece(
                    ' ',
                    false,
                    new Position(i, 2)));
            board.add(Piece.getPiece(
                    ' ',
                    true,
                    new Position(i, SIZE-1)));
        }
    }



    public Move move(String currentPos, String newPos) {
        Position currentPosition = Piece.toIntPosition(currentPos),
                newPosition = Piece.toIntPosition(newPos);
        Piece pieceToMove = null;

        // Ensure both positions are on the board
        if (currentPosition == null || newPosition == null) {
            System.out.println("Position is not on the board");
            return null;
        }

        // Find the piece to move
        for (Piece p: board) {
            if (p.getIntPosition().equals(currentPosition)) {
                pieceToMove = p;
            }
        }

        // Ensure there is a piece at the position that is getting moved
        if (pieceToMove == null) {
            System.out.println("No piece at that position");
            return null;
        }

        return move(pieceToMove, newPosition.x - currentPosition.x, newPosition.y - currentPosition.y);
    }

    public Move move(Piece piece, int dx, int dy) {
        // Ensure there is not a piece in the way
        boolean legal = isValidMove(piece, dx, dy);
        if (!(legal)) return null;

        String oldPos = piece.getChessPosition();

        // Handle pawns
        // TODO: Add functionality for taking properly
        if (piece.getSymbol() == ' ' && Math.abs(dx) == 1)
            legal = piece.take(dx, dy);
        else
            legal = piece.move(dx, dy);

        if (legal) {
            return new Move(piece, oldPos, false);
        }
        return null;
    }

    public boolean isValidMove(Piece pieceToMove, int dx, int dy) {
        boolean legal = true;
        char symbol = pieceToMove.getSymbol();

        if (symbol != 'N' && symbol != ' ' && symbol != 'K') {
            Position[] intermediates = pieceToMove.intermediatesForMove(dx, dy);

            if (intermediates == null) {
                legal = false;
                System.out.println("ERROR: Move is invalid for the piece");
            } else  {
                // Check intermediate positions
                for (Position pos : intermediates) {
                    for (Piece piece : board) {
                        if (piece.getIntPosition().equals(pos)) {
                            legal = false;
                            System.out.println("ERROR: There is a piece in the way");
                        }
                    }
                }
            }
        } else if (symbol != ' ') {
            legal = pieceToMove.isValidMove(dx, dy);
            if (!(legal)) System.out.println("Move is illegal for the piece");
        }

        if (!(legal)) return false;

        // Check final position
        Position finalPos = pieceToMove.getIntPosition().translate(dx, dy);
        for (Piece piece: board) {
            if (piece.getIntPosition().equals(finalPos) && (piece.getSide() == pieceToMove.getSide())) {
                System.out.println("ERROR: There is a piece in the way");
                legal = false;
            }
        }

        // Handle pawns taking
        if (symbol == ' ') {
            if (!(legal)) {
                Pawn pawnToMove = (Pawn) pieceToMove;
                legal = pawnToMove.isValidTake(dx, dy);
            } else {
                legal = pieceToMove.isValidMove(dx, dy);
            }
        }

        return legal;
    }

    public String toString() {
        String[][] boardArray = new String[SIZE][SIZE];

        for (Piece piece: board) {
            Position pos = piece.getIntPosition();

            boardArray[pos.y-1][pos.x-1] = Character.toString(piece.getSide()) + piece.getSymbol();
        }

        StringBuilder output = new StringBuilder();

        // Add headers
        output.append("   ");
        for (int i = 0; i < SIZE; i++) {
            output.append((char)('a' + i)).append("  ");
        }
        output.append("\n");

        output.append("---".repeat(SIZE+1));
        output.append("\n");

        // Add main body
        int counter =0;
        for (String[] row: boardArray) {
            output.append(8-counter).append("| ");
            counter++;

            for (String space: row) {
                if (space == null)
                    output.append("__");
                else if (space.equals(" "))
                    output.append("p");
                else
                    output.append(space);
                output.append(" ");
            }
            output.append("\n");
        }

        return output.toString();
    }

    public Piece getPiece(String position) {
        for (Piece piece: board) {
            if (position.equalsIgnoreCase(piece.getChessPosition())) {
                return piece;
            }
        }
        return null;
    }
}
