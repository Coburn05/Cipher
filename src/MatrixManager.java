package src;

public class MatrixManager {
    // DOES NOT HANDLE RANDOMIZATION
    // ONLY DOES LETTER TO CHARACTER CONVERSION
    // define matrix here
    //  - will exist as two matrices
    //    - one is english
    //    - other is characters
    //  - same indexes will have same values
    // along with any functions to modify it
    //  - rotate
    //  - shift
    //  - moving shift?

    // represents the "letters" on the matrix
    // using a letters row and column we can find its character pair
    private String[][] matrixRef = {
            {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"},
            {"l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v"},
            {"w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7"},
            {"8", "9", "0", " ", "a", "b", "c", "d", "e", "f", "g"},
            {"h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r"},
            {"s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3"},
            {"4", "5", "6", "7", "8", "9", "0", " ", "a", "b", "c"},
            {"d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n"},
            {"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y"},
            {"z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"},
            {"_", "a", "e", "i", "o", "u", "y", " ", "a", "e", "i"}
    };

    // this represents the characters for the row and column at their index
    private String[][] matrixVals = {
            {"1", "3", "7", "A", "%", "@", "&", "g", "{", ">", "#"},
            {"2", "5", "C", "N", ")", ">", "<", "G", "!", "(", "]"}
    };

    public static String getFirstChar(char letter, int randNum) {
        return "NULL";
    }

    public static String getSecondChar(char letter, int randNum) {
        return "NULL";
    }

    public static int getNumWays(char letter) { return -1; }
}
