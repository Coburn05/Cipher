package src;

public class MatrixManager {
    // DOES NOT HANDLE RANDOMIZATION
    // ONLY DOES LETTER TO CHARACTER CONVERSION
    // This class manages the transformation of letters to character pairs using a predefined matrix

    // Define the matrix here
    //  - One matrix holds the English letters
    //  - Another matrix holds corresponding encoded characters
    //  - The same index in both matrices refers to the same encoded pair

    // The matrix that holds the letters to be encoded
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
            {':', ';', '\\', '\'', ',', '<', '.', '>', '/', '?', '\\', '|', '{', '}', '[', ']'},
            {'_', '-', '=', '+', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'}
    };

    // Matrix holding corresponding character pairs for the letters in the `matrixRef`
    private static final String[][] matrixVals = {
            {"1", "3", "7", "A", "%", "@", "&", "g", "{", ">", "#", "R", "a", ")", "\\", "p"},
            {"2", "5", "C", "N", ")", ">", "<", "G", "!", "(", "]", "A", "B", "#", "%", "^"}
    };

    // Method to get the location (row, col) of a character in the matrix based on random variation
    private static int[] getLocChar(char letter, int randNum) {
        int[] start = MatrixManager.getStart(letter, randNum); // Get the starting point based on variation
        
        for(int col = start[0]; col < matrixRef.length; col++) {
            for (int row = start[1]; row < matrixRef[col].length; row++) {
                if (letter == matrixRef[row][col])
                    return new int[]{row, col}; // Return location if found
            }
        }
        System.out.println("Could not find char...");
        return new int[]{-1, -1}; // Return an invalid location if character not found
    }

    // Method to get the character pair (from `matrixVals`) for a given letter and its variation
    public static String getCharPair(char letter, int randNum) {
        int[] loc = getLocChar(letter, randNum);
        // loc[row, col]
        return (matrixVals[0][loc[1]] + matrixVals[1][loc[0]]); // Return the character pair from matrixVals
    }

    // Needs to be updated: This method returns the number of ways a letter can be encoded
    public static int getNumWays(char letter) {
        return switch(letter) {
            case 'a', 'i', 'y' -> 5; // Some letters have 5 variations
            case 't', 'f', 'c', 'k', 'j', 'h', 'w',
                 'r', 'e', 'q', 'd', 'b', 'g', 'o',
                 'm', 'u', 's', 'v', 'l', '4', '3',
                 '1', '7', 'x', '2', '6', 'z', '5',
                 '8', '9' -> 4; // These letters have 4 variations
            case 'N', 'M', 'R', 'P', 'S', 'O', 'Q',
                 'W', 'U', 'X', 'T', 'V', 'Y', 'Z',
                 '+' -> 2; // These letters have 2 variations
            default -> 1; // Other characters have only 1 variation
        };
    }

    // Method to get the starting location of the letter based on variation number
    // looks soooooo good :)
    private static int[] getStart(char letter, int variation) {
        int numSeen = 0;
        for(int row = 0; row < matrixRef.length; row++) {
            for (int col = 0; col < matrixRef[row].length; col++) {
                //System.out.println(matrixRef[row][col] + " Looking for: " +  letter);
                if (letter == matrixRef[row][col]) {
                    numSeen++;
                    if (numSeen == variation) {
                        //System.out.println("return: " + row + " " + col);
                        return new int[]{col, row}; // Return when the correct variation is found
                    }
                }
            }
        }
        return new int[]{0, 0}; // Return default location if not found
    }

    // Method to get a letter from the encoded character pair
    public static char getLetterFromPair(String pair) {
        String first = pair.substring(0, 1);
        String second = pair.substring(1);

        int col = 0;
        int row = 0;

        // Find the column index for the first part of the pair
        for(int i = 0; i < matrixVals[0].length; i++) {
            if (matrixVals[0][i].equals(first)) {
                col = i;
                break;
            }
        }

        // Find the row index for the second part of the pair
        for(int i = 0; i < matrixVals[1].length; i++) {
            if (matrixVals[1][i].equals(second)) {
                row = i;
                break;
            }
        }

        //System.out.println(first + " " + second);
        return matrixRef[row][col]; // Return the corresponding letter from matrixRef
    }
}