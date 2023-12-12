package pieces;

import board.Position;

public class Rook extends Piece {
    public Rook(boolean white, Position position) {
        super('R', white, position);
    }

    @Override
    public boolean move(int dx, int dy) {
        if (!(isValidMove(dx, dy)))      // Orthogonal condition
            return false;

        return super.move(dx, dy);
    }

    @Override
    public Position[] intermediatesForMove(int dx, int dy) {
        if (!(isValidMove(dx, dy))) return null;

        Position[] intermediates;

        if (dx == 0) {
            // Vertical movement

            intermediates = new Position[Math.abs(dy)-1];

            if (dy > 0) {
                for (int i = 1; i < dy; i++) {
                    intermediates[i-1] = position.translate(0, i);
                }
            } else {
                for (int i = -1; i > dy; i--) {
                    intermediates[Math.abs(i)-1] = position.translate(0, i);
                }
            }

        } else {
            // Horizontal movement
            intermediates = new Position[Math.abs(dx) - 1];

            if (dy > 0) {
                for (int i = 1; i < dx; i++) {
                    intermediates[i] = position.translate(i, 0);
                }
            } else {
                for (int i = -1; i > dx; i--) {
                    intermediates[Math.abs(i)-1] = position.translate(i, 0);
                }
            }
        }

        return intermediates;
    }

    @Override
    public boolean isValidMove(int dx, int dy) {
        if (!(((dx == 0) || (dy == 0)))) return false;

        return super.isValidMove(dx, dy);
    }
}
