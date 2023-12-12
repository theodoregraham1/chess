import board.Chess;

public class Main {
    public static void main(String[] args) {
        Chess chess = new Chess();
        System.out.print(chess);

        System.out.println(chess.move("a8", "a4"));
        System.out.println(chess);
    }
}
