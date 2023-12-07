import java.util.ArrayList;

public class Chess {
    private static final int SIZE = 8;
    private static final char[] STARTING_BACK_ROW = {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'};

    private ArrayList<String> moves;
    private ArrayList<Piece> board;

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

    public boolean move(String currentPos, String newPos) {
        Position currentPosition = Piece.toIntPosition(currentPos),
                newPosition = Piece.toIntPosition(newPos);
        Piece pieceToMove = null;

        // Ensure both positions are on the board
        if (currentPosition == null || newPosition == null)
            return false;

        // Find the piece to move
        for (Piece p: board) {
            if (p.getIntPosition().equals(currentPosition)) {
                pieceToMove = p;
            }
        }

        // Ensure there is a piece at the position that is getting moved
        if (pieceToMove == null) {
            return false;
        }
        return move(pieceToMove, newPosition.x - currentPosition.x, newPosition.y - currentPosition.y)
    }

    public boolean move(Piece piece, int dx, int dy) {
        Position newPosition = piece.getIntPosition().translate(dx, dy);

        // Ensure there is not a piece in the way
        boolean legal = true;
        for (Piece p: board) {
            if (p.getIntPosition().equals(newPosition)) {
                legal = false;
            }
        }
        if (!(legal))
            return false;

        return piece.move(dx, dy);
    }

    public String toString() {
        System.out.println(board);
        String[][] boardArray = new String[SIZE][SIZE];

        for (Piece piece: board) {
            Position pos = piece.getIntPosition();

            boardArray[pos.y-1][pos.x-1] = Character.toString(piece.getSymbol());
        }

        StringBuilder output = new StringBuilder();
        for (String[] row: boardArray) {
            for (String space: row) {
                if (space == null)
                    output.append("_");
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
