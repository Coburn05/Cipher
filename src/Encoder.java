package src;

public class Encoder {
    //private String plainText;
    private final String level1Encryption;

    // read input from user
    // convert to encoded message

    public Encoder(String plainText) {
        level1Encryption = matrixEncode(plainText);
    }

    public String getLevel1Message() {
        return level1Encryption;
    }

    private static String matrixEncode(String plainText) {
        StringBuilder encrypted = new StringBuilder();
        for(char letter: plainText.toCharArray()) {
            encrypted.append(getPairFromMatrix(letter));
        }
        return encrypted.toString();
    }

    private static String getPairFromMatrix(char letter) {
        // get randomized "instance" of letter picked
            // tell matrix manager what letter it returns number of
             // ways that it can be written
            // using this pick random number 1-num and pass that to get letter
        int randNum = -1;

        String first = MatrixManager.getFirstChar(letter, randNum);
        String second = MatrixManager.getSecondChar(letter, randNum);

        return first + second;
    }
}
