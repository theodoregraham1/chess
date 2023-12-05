public class Bishop extends Piece {
    public Bishop(boolean white, Position pos) {
        super('B', white, pos);
    }

    // Move Bishop and return whether move is valid
    public boolean move(int dx, int dy) {
        if (((dy != dx)
                || (dx == 0)
                || !(position.isValid(dx, dy))))
            return false;

        position.x += dx;
        position.y += dy;

        return true;
    }
}
