public class Pawn extends Piece {
    public Pawn(boolean white, Position position) {
        super(' ', white, position);
    }

    // Make the pawn move and check it's valid
    public boolean move(int dx, int dy) {
        if ((dx != 0)
                || (dy != 1)
                || !(position.isValid(dx, dy)))
            return false;

        position.y += dy;

        return true;
    }

    // Make the pawn move on a take and check it's valid
    public boolean take(int dx, int dy) {
        if (((Math.abs(dx) != 1) || (dy != 1)))   // Diagonal take
            // TODO: En Passant
            return false;

        position.x += dx;
        position.y += dy;

        return true;
    }
}
