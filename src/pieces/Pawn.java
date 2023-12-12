package pieces;

import board.Position;

public class Pawn extends Piece {
    public Pawn(boolean white, Position position) {
        super(' ', white, position);
    }

    // Make the pawn move and check it's valid
    public boolean move(int dx, int dy) {
        if ((dx != 0) || (dy != 1))
            return false;

        return super.move(dx, dy);
    }

    // Make the pawn move on a take and check it's valid
    public boolean take(int dx, int dy) {
        if (((Math.abs(dx) != 1) || (dy != 1))   // Diagonal take
            && !((position.y == 5) && white && (dx == 0))   // En passant for white
            && !((position.y == 3) && !(white) && (dx == 0))) // En passant for black
            return false;

        return super.move(dx, dy);
    }
}
