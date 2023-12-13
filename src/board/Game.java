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
        System.out.printf("%s's turn:%n", name);
        Piece pieceToMove = null;

        while (pieceToMove == null) {
            System.out.print("Enter start position: ");
            String startPos = inputScanner.nextLine();

            pieceToMove = chessBoard.getPiece(startPos);
        }

        Position endPos = null;
        int dx = 0;
        int dy = 0;

        while (endPos == null) {
            System.out.print("Enter end position:");
            endPos = Piece.toIntPosition(inputScanner.next());
            Position startPos = pieceToMove.getIntPosition();

            if (endPos != null) {
                dx = endPos.x - startPos.x;
                dy = endPos.y - startPos.y;

                if (!(pieceToMove.isValidMove(dx, dy))) {
                    endPos = null;
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
}
