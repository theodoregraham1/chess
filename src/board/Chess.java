package board;

import pieces.Pawn;
import pieces.Piece;

import java.util.ArrayList;
import java.util.Scanner;

public class Chess {
    private static final int SIZE = 8;
    private static final char[] STARTING_BACK_ROW = {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'};

    private final ArrayList<Move> moves;
    private final ArrayList<Piece> board;

    public Chess() {
        moves = new ArrayList<>();
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

    public static void main(String[] args) {
        Chess chess = new Chess();
        Scanner input = new Scanner(System.in);

        while (true) {
            String command = input.nextLine();

            // TODO
        }
    }

    public boolean move(String currentPos, String newPos) {
        Position currentPosition = Piece.toIntPosition(currentPos),
                newPosition = Piece.toIntPosition(newPos);
        Piece pieceToMove = null;

        // Ensure both positions are on the board
        if (currentPosition == null || newPosition == null) {
            System.out.println("Position is not on the board");
            return false;
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
            return false;
        }
        return move(pieceToMove, newPosition.x - currentPosition.x, newPosition.y - currentPosition.y);
    }

    private boolean move(Piece piece, int dx, int dy) {
        // Ensure there is not a piece in the way
        boolean legal = isValidMove(piece, dx, dy);
        if (!(legal)) return false;

        String oldPos = piece.getChessPosition();

        // Handle pawns
        if (piece.getSymbol() == ' ' && Math.abs(dx) == 1)
            legal = piece.take(dx, dy);
        else
            legal = piece.move(dx, dy);

        if (legal) {
            moves.add(new Move(piece, oldPos, false));
            System.out.println(moves.get(moves.size()-1));
        }
        return legal;
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
        for (String[] row: boardArray) {
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
}
