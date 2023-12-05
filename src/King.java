public class King extends Piece {
    public King(boolean white, Position position) {
        super('K', white, position);
    }

    public boolean move(int dx, int dy) {
        if (((dx == 0) && (dy == 0) || position.isValid(dx, dy))) {
            if (dx < 0)
                position.x--;
            else if (dx > 0)
                position.x++;

            if (dy < 0)
                position.y--;
            else if (dy > 0)
                position.y++;

            return true;
        }

        return false;
    }
}
