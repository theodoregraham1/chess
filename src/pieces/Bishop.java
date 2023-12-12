package pieces;

import board.Position;

public class Bishop extends Piece {
    public Bishop(boolean white, Position pos) {
        super('B', white, pos);
    }

    // Move Bishop and return whether move is valid
    @Override
    public boolean move(int dx, int dy) {
        if (!(isValidMove(dx, dy)))
            return false;

        return super.move(dx, dy);
    }

    @Override
    public Position[] intermediatesForMove(int dx, int dy) {
        if (!(isValidMove(dx, dy))) return null;

        Position[] intermediates = new Position[Math.abs(dx)-1];

        if (dx > 0) {
            for (int i = 1; i < dx; i++) {
                intermediates[i] = position.translate(i, i);
            }
        } else {
            for (int i = -1; i > dx; i--) {
                intermediates[i] = position.translate(i, i);
            }
        }

        return intermediates;
    }

    @Override
    public boolean isValidMove(int dx, int dy) {
        if ((dy != dx) || (dx == 0))
            return false;
        return super.isValidMove(dx, dy);
    }
}
