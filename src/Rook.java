public class Rook extends Piece {
    public Rook(boolean white, Position position) {
        super('R', white, position);
    }

    public boolean move(int dx, int dy) {
        if (!(((dx == 0) || (dy == 0))))      // Orthogonal condition
            return false;

        return super.move(dx, dy);
    }
}
