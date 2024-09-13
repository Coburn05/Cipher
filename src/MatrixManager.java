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
    private static String[][] matrixRef = {
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
    private static String[][] matrixVals = {
            {"1", "3", "7", "A", "%", "@", "&", "g", "{", ">", "#"},
            {"2", "5", "C", "N", ")", ">", "<", "G", "!", "(", "]"}
    };

    private static int[] getLocChar(char letter, int randNum) {
        int start[] = MatrixManager.getStart(letter, randNum);

        for(int x = start[0]; x < matrixRef.length; x++) {
            for(int y = start[1]; y < matrixRef[x].length; y++) {
                if(String.valueOf(letter).equals(matrixRef[x][y]))
                    return new int[]{x, y};
            }
        }
        return new int[]{-1, -1};
    }

    public static String getCharPair(char letter, int randNum) {
        int loc[] = getLocChar(letter, randNum);
        return (matrixVals[0][loc[0]] + matrixVals[1][1]);
    }

    public static int getNumWays(char letter) {
        return switch (letter) {
            case 'a', 'e', 'i' -> 5;
            case 'o', 'u', 'y' -> 4;
            default -> 3;
        };
    }

    private static int[] getStart(char letter, int variation) {
        int numSeen = 0;
        for(int x = 0; x < matrixRef.length; x++) {
            for(int y = 0; y < matrixRef[x].length; y++) {
                if(String.valueOf(letter).equals(matrixRef[x][y])) {
                    numSeen++;
                    if(numSeen > variation)
                        return new int[]{x, y};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
