package board;

public class Position {
    // Coordinate 1-8 in both axes
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Returns whether the position is valid (i.e. on the chess board)
    public boolean isValid() {
        return this.isValid(0, 0);
    }
    public boolean isValid(int dx, int dy) {
        int newX = x + dx;
        int newY = y + dy;
        return (newX <= 8) && (newX > 0)
                && (newY <= 8) && (newY > 0);
    }

    public Position translate(int dx, int dy) {
        return new Position(x + dx, y + dy);
    }

    public String toString() {
        return String.format("(%d, %d)", x, y);
    }

    public boolean equals(Position pos2) {
        return (pos2.x == this.x && pos2.y == this.y);
    }
}
