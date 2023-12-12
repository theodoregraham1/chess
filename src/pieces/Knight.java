package pieces;

import board.Position;

public class Knight extends Piece {
    public Knight(boolean white, Position pos) {
        super('N', white, pos);
    }

    // Move pieces.Knight and return whether move is valid
    public boolean move(int dx, int dy) {
        if ((Math.abs(dx) + Math.abs(dy)) != 3)
            return false;

        return super.move(dx, dy);
    }
}
