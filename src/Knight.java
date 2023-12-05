public class Knight extends Piece {
    public Knight(boolean white, Position pos) {
        super('N', white, pos);
    }

    public boolean move(int x, int y) {
        return false;
    }
}
