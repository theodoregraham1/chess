package pieces;

import board.Position;

public class Pawn extends Piece {
    public Pawn(boolean white, Position position) {
        super(' ', white, position);
    }

    // Make the pawn move and check it's valid
    public boolean move(int dx, int dy) {
        if (!(isValidMove(dx, dy))) return false;

        return super.move(dx, dy);
    }

    // Make the pawn move on a take and check it's valid
    public boolean take(int dx, int dy) {
        if (!(isValidTake(dx, dy)))
            return false;

        return super.move(dx, dy);
    }

    public boolean isValidTake(int dx, int dy) {
        return (Math.abs(dx) == 1 && Math.abs(dy) == 1)   // Diagonal take
                || (position.y == 5 && white && dx == 0)   // En passant for white
                || (position.y == 3 && !white && dx == 0); // En passant for black
    }

    @Override
    public Position[] intermediatesForMove(int dx, int dy) {
        if (!(isValidMove(dx, dy))) return null;

        return new Position[0];
    }

    @Override
    public boolean isValidMove(int dx, int dy) {
        if (!(dx == 0
                && ((dy == -1 && white) || (dy == 1 && !white)
                    || (dy == -2 && white && position.y == 7)
                    || (dy == 2 && !white && position.y == 2))
        ))
            return false;

        return super.isValidMove(dx, dy);
    }
}
