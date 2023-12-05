public class King extends Piece {
    public King(boolean white, Position position) {
        super('K', white, position);
    }

    // Move King and return whether move is valid
    public boolean move(int dx, int dy) {
        if (((dx == 0) && (dy == 0))
                || (dx < -1) || (dx > 1)
                || (dy < -1) || (dy > 1)
                || !(position.isValid(dx, dy)))
            return false;

        position.x += dx;
        position.y += dy;

        return true;
    }
}
