import board.Chess;

public class Main {
    public static void main(String[] args) {
        Chess chess = new Chess();
        System.out.print(chess);

        chess.move("b8", "c6");
        System.out.println(chess);
    }
}
