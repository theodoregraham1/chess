public class King extends Piece {
    public King(boolean white, int[] position) {
        super('K', white, position);
    }

    public void move(int x, int y) {
        if (x < 0) {
            position[0] --;
        } else if (x > 0) {
            position[0] ++;
        }
        if (y < 0) {
            position[1] --;
        } else if (y > 0) {
            position[1] ++;
        }
    }
}
