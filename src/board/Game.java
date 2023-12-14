package board;

import pieces.Piece;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private final Chess chessBoard;
    private final ArrayList<Move> moves;

    public Game() {
        chessBoard = new Chess();
        moves = new ArrayList<>();
    }

    public void run() {
        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            System.out.println(chessBoard);
            moves.add(turn(true, inputScanner));
            System.out.println(moves.get(moves.size()-1));

            System.out.println(chessBoard);
            moves.add(turn(false, inputScanner));
            System.out.println(moves.get(moves.size()-1));
        }
    }

    public Move turn(boolean white, Scanner inputScanner) {
        // Print whose turn it is
        String name;
        if (white) {
            name = "White";
        } else {
            name = "Black";
        }
        System.out.printf("%s's turn:%n", name);

        Piece pieceToMove = getPieceFromInput(white, inputScanner);

        // Find the end position of the piece and check it is valid
        Position endPos = null;
        int dx = 0;
        int dy = 0;

        while (endPos == null) {
            System.out.print("Enter end position:");
            String inputText = inputScanner.next();

            if (inputText.equalsIgnoreCase("back")) {
                // Allow user to go back to choosing start position
                pieceToMove = getPieceFromInput(white, inputScanner);
                endPos = null;

            } else {
                // Find if the move is valid
                endPos = Piece.toIntPosition(inputText);
                Position startPos = pieceToMove.getIntPosition();

                // Check validity
                if (endPos != null) {
                    dx = endPos.x - startPos.x;
                    dy = endPos.y - startPos.y;

                    if (!(pieceToMove.isValidMove(dx, dy))) {
                        System.out.println("Move invalid");
                        endPos = null;
                    }
                }
            }
        }
        Move move = chessBoard.move(pieceToMove, dx, dy);

        while (move == null) {
            System.out.println("Move invalid");
            move = turn(white, inputScanner);
        }
        return move;
    }

    private Piece getPieceFromInput(boolean white, Scanner inputScanner) {
        // Find the piece from its starting position
        Piece pieceToMove = null;
        while (pieceToMove == null) {
            System.out.print("Enter start position: ");
            String startPos = inputScanner.next();

            pieceToMove = chessBoard.getPiece(startPos);

            if (pieceToMove != null) {
                if (pieceToMove.isWhite() != white) {
                    pieceToMove = null;
                }
            }
        }
        return pieceToMove;
    }
}
