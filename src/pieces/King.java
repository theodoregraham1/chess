package pieces;

import board.Position;

public class King extends Piece {
    public King(boolean white, Position position) {
        super('K', white, position);
    }

    // Move pieces.King and return whether move is valid
    @Override
    public boolean move(int dx, int dy) {
        if (!(super.isValidMove(dx, dy))) return false;

        return super.move(dx, dy);
    }

    @Override
    public Position[] intermediatesForMove(int dx, int dy) {
        if (!(isValidMove(dx, dy))) return null;

        return new Position[0];
    }

    @Override
    public boolean isValidMove(int dx, int dy) {
        if ((dx < -1) || (dx > 1)
                || (dy < -1) || (dy > 1))
            return false;

        return super.isValidMove(dx, dy);
    }
}
