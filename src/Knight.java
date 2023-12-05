public class Knight extends Piece {
    public Knight(boolean white, Position pos) {
        super('N', white, pos);
    }

    public boolean move(int dx, int dy) {
        return false;
    }
}
