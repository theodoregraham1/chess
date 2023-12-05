public class King extends Piece {
    public King(boolean white, Position position) {
        super('K', white, position);
    }

    public boolean move(int x, int y) {
        if ((x == 0) && (y == 0))
            return false;

        if (x < 0)
            position.x--;
        else if (x > 0)
            position.x++;

        if (y < 0)
            position.y--;
        else if (y > 0)
            position.y++;

        return true;
    }
}
