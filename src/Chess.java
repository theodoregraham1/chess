import java.util.ArrayList;

public class Chess {
    private static final int SIZE = 8;
    private static final char[] STARTING_BACK_ROW = {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'};

    private ArrayList<Piece> board;

    public Chess() {
        board = new ArrayList<>();

        // Make black and white back rows and pawns
        for (int i = 1; i < SIZE+1; i++) {
            // Add back rows
            board.add(new Piece(
                    STARTING_BACK_ROW[i],
                    false,
                    new int[]{i, 1}));
            board.add(new Piece(
                    STARTING_BACK_ROW[i],
                    true,
                    new int[]{i, SIZE}));

            // Add pawns
            board.add(new Piece(
                    ' ',
                    false,
                    new int[]{i, 1}));
            board.add(new Piece(
                    ' ',
                    true,
                    new int[]{i, SIZE-1}));
        }
    }

    public void display() {
        for (Piece p: board) {
            if (p != null)
                System.out.print(p + " ");
            else
                System.out.print("_ ");
        }
        System.out.println();
    }
}
