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
            moves.add(turn(true, inputScanner));
            System.out.println(moves.get(moves.size()-1));
        }
    }

    public Move turn(boolean white, Scanner inputScanner) {
        String name;
        if (white) {
            name = "White";
        } else {
            name = "Black";
        }

        Piece pieceToMove = null;

        while (pieceToMove == null) {
            System.out.printf("%s's turn: \n Enter start position:%n", name);
            String startPos = inputScanner.nextLine();

            pieceToMove = chessBoard.getPiece(startPos);
        }

        Position endPos = null;
        int dx = 0;
        int dy = 0;

        while (endPos == null) {
            System.out.println("Enter end position:");
            endPos = Piece.toIntPosition(inputScanner.next());
            Position startPos = pieceToMove.getIntPosition();

            if (endPos != null) {
                dx = startPos.x - endPos.x;
                dy = startPos.y - endPos.y;

                if (!(pieceToMove.isValidMove(dx, dy))) {
                    endPos = null;
                }
            }
        }

        return chessBoard.move(pieceToMove, dx, dy);
    }
}
