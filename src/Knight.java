public class Knight extends Piece {
    public Knight(boolean white, Position pos) {
        super('N', white, pos);
    }

    // Move Knight and return whether move is valid
    public boolean move(int dx, int dy) {
        if ((Math.abs(dx) + Math.abs(dy)) != 3)
            return false;

        position.x += dx;
        position.y += dy;

        return true;
    }
}
