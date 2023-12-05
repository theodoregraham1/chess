public class Queen extends Piece {
    public Queen(boolean white, Position position) {
        super('Q', white, position);
    }

    // Move Queen and make sure it is valid
    public boolean move(int dx, int dy) {
        if(!((dx == dy) && (dx != 0))           // Diagonal condition
            && !(((dx == 0) || (dy == 0)))      // Orthogonal condition
            && !(position.isValid(dx, dy)))
            return false;

        position.x += dx;
        position.y += dy;

        return true;
    }
}
