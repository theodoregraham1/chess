public class King extends Piece {
    public King(boolean white, Position position) {
        super('K', white, position);
    }

    // Move King and return whether move is valid
    public boolean move(int dx, int dy) {
        if ((dx < -1) || (dx > 1)
                || (dy < -1) || (dy > 1))
            return false;

        return super.move(dx, dy);
    }
}
