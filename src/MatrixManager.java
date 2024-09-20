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
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'q', 'w', 'e', 'r', 't'},
            {'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'y', 'u', 'i', 'o', 'p'},
            {'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', 'a', 's', 'd', 'f', 'g'},
            {'8', '9', '0', ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'z'},
            {'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 'x', 'c', 'v', 'b', 'n'},
            {'s', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', 'm', 'A', 'B', 'C', 'D'},
            {'4', '5', '6', '7', '8', '9', '0', ' ', 'a', 'b', 'c', 'E', 'F', 'G', 'H', 'I'},
            {'d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'J', 'K', 'L', 'M', 'N'},
            {'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'O', 'P', 'Q', 'R', 'S'},
            {'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'T', 'U', 'V', 'W', 'X'},
            {' ', 'a', 'e', 'i', 'o', 'u', 'y', ' ', 'a', 'e', 'i', 'Y', 'Z', '!', '@', '#'},
            {'$', '%', '^', '&', '*', '(', ')', '1', '2', '3', '4', '5', '6', '7', '8', '9'},
            {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'},
            {'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '+', '+', '+', '+', '+', '+'},
            {':', ';', '\'', '\'', ',', '<', '.', '>', '/', '?', '\\', '|', '{', '}', '[', ']'},
            {'_', '-', '=', '+', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'}
    };

    // this represents the  characters for the row and column at their index
    private static final String[][] matrixVals = {
            {"1", "3", "7", "A", "%", "@", "&", "g", "{", ">", "#", "R", "a", ")", "\\", "p"},
            {"2", "5", "C", "N", ")", ">", "<", "G", "!", "(", "]", "A", "B", "#", "%", "^"}
    };

    private static int[] getLocChar(char letter, int randNum) {
        int[] start = MatrixManager.getStart(letter, randNum);

        for(int col = start[0]; col < matrixRef.length; col++) {
            for(int row = start[1]; row < matrixRef[col].length; row++) {
                if(letter == matrixRef[row][col])
                    return new int[]{row, col};
            }
        }
        System.out.println("could not find char...");
        return new int[]{-1, -1};
    }

    public static String getCharPair(char letter, int randNum) {
        int[] loc = getLocChar(letter, randNum);
        // loc[row, col]
        return (matrixVals[0][loc[1]] + matrixVals[1][loc[0]]);
    }

    // needs to be updated
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
        return new int[]{0, 0};
    }

    public static char getLetterFromPair(String pair) {
        String first = pair.substring(0, 1);
        String second = pair.substring(1);

        int col = 0;
        int row = 0;

        for(int i = 0; i < matrixVals[0].length; i++) {
            if(matrixVals[0][i].equals(first)) {
                col = i;
                break;
            }
        }

        for(int i = 0; i < matrixVals[1].length; i++) {
            if(matrixVals[1][i].equals(second)) {
                row = i;
                break;
            }
        }

        System.out.println(first + " " + second);
        return matrixRef[row][col];
    }

    // pair must be a 2 letter string
    public static Integer[] getLocation(String pair) {
        Integer[] locs = new Integer[2];
        String first = String.valueOf(pair.indexOf(0));
        String second = String.valueOf(pair.indexOf(1));
        System.out.println(first + "  " + second  + "this");
        for(int i = 0; i < matrixRef[0].length; i++) {
            boolean found = false;
            if(first.equals(matrixRef[0][i]) && !found) {
                found = true;
                locs[0] = i;
                System.out.println("found somthing: " + i);
            }
        }

        for(int i = 0; i < matrixRef[0].length; i++) {
            if(second.equals(matrixRef[1][i])) {
                locs[1] = i;
                break;
            }
        }

        return locs;
    }
}
