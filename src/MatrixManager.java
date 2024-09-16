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
    private static char[][] matrixRef = {
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'},
            {'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v'},
            {'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7'},
            {'8', '9', '0', ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g'},
            {'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r'},
            {'s', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3'},
            {'4', '5', '6', '7', '8', '9', '0', ' ', 'a', 'b', 'c'},
            {'d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n'},
            {'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y'},
            {'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'},
            {' ', 'a', 'e', 'i', 'o', 'u', 'y', ' ', 'a', 'e', 'i'}
    };

    // this represents the  characters for the row and column at their index
    private static String[][] matrixVals = {
            {"1", "3", "7", "A", "%", "@", "&", "g", "{", ">", "#"},
            {"2", "5", "C", "N", ")", ">", "<", "G", "!", "(", "]"}
    };

    private static int[] getLocChar(char letter, int randNum) {
        int start[] = MatrixManager.getStart(letter, randNum);

        for(int col = start[0]; col < matrixRef.length; col++) {
            for(int row = start[1]; row < matrixRef[col].length; row++) {
                if(letter == matrixRef[row][col])
                    return new int[]{row, col};
            }
        }
        return new int[]{-1, -1};
    }

    public static String getCharPair(char letter, int randNum) {
        int loc[] = getLocChar(letter, randNum);
        // loc[row, col]
        return (matrixVals[0][loc[1]] + matrixVals[1][loc[0]]);
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
        for(int row = 0; row < matrixRef.length; row++) {
            for(int col = 0; col < matrixRef[row].length; col++) {
                //System.out.println(matrixRef[row][col] + " Looking for: " +  letter);
                if(letter == matrixRef[row][col]) {
                    numSeen++;
                    if(numSeen == variation) {
                        //System.out.println("return: " + row + " " + col);
                        return new int[]{col, row};
                    }
                }
            }
        }
        System.out.println("hh");
        return new int[]{-1, -1};
    }

    public static char getLetterFromPair(String pair) {
        String first = pair.substring(0, 1);
        String second = pair.substring(1);

        System.out.println(first + " " + second);
        return 'a';
    }
}
