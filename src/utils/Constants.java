package utils;

public class Constants {
    public static final Character[] LETTERS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    public static final int SIZE = 8;
    public static final char[] STARTING_BACK_ROW = {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'};

    public static int findInLetters(char letter) {
        int index = -1;
        for (int i = 0; i < Constants.SIZE; i++) {
            if (letter == Constants.LETTERS[i])
                index = i;
        }

        return index;
    }
}
