import java.util.Arrays;

public class Chess {
    private static final String[] STARTING_BACK_ROW = {"Rook", "Knight", "Bishop", "Queen", "King", "Bishop", "Knight", "Rook"};

    private Piece[][] board;

    public Chess() {
        board = new Piece[8][8];

        // Make black and white back rows and pawns
        for (int i = 0; i < board.length; i++) {
            board[0][i] = new Piece(STARTING_BACK_ROW[i], false);
            board[board.length - 1][i] = new Piece(STARTING_BACK_ROW[i], true);

            board[1][i] = new Piece("Pawn", false);
            board[board.length - 2][i] = new Piece("Pawn", true);
        }

        System.out.println(Arrays.deepToString(board));
    }
}
