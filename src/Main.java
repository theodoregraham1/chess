import board.Chess;

public class Main {
    public static void main(String[] args) {
        Chess chess = new Chess();
        System.out.print(chess);

        chess.move("a7", "a5");
        System.out.println(chess);
    }
}
