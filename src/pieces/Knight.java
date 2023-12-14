package pieces;

import board.Position;

public class Knight extends Piece {
    public Knight(boolean white, Position pos) {
        super('N', white, pos);
    }

    // Move pieces.Knight and return whether move is valid
    public boolean move(int dx, int dy) {
        if (!(isValidMove(dx, dy))) return false;

        return super.move(dx, dy);
    }

    @Override
    public Position[] intermediatesForMove(int dx, int dy) {
        if (!(isValidMove(dx, dy))) return null;

        return new Position[0];
    }

    @Override
    public boolean isValidMove(int dx, int dy) {
        if ((Math.abs(dx) + Math.abs(dy)) != 3
                || dx == 0 || dy == 0)
            return false;

        return super.isValidMove(dx, dy);
    }
}
