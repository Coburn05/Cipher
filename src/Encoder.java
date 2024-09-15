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
        int n = MatrixManager.getNumWays(letter);
        int randNum = (int)(Math.random() * n) + 1;

        return MatrixManager.getCharPair(letter, randNum);
    }

    public static String convertMsg(String msgPlainText) {
        String encodedLvl1 = "";

        for(char letter: msgPlainText.toCharArray()) {
            System.out.print(letter + " ");
            System.out.println(getPairFromMatrix(letter));
            encodedLvl1 += getPairFromMatrix(letter);
        }

        System.out.println(encodedLvl1);
        return encodedLvl1;
    }

    public static void main(String[] args) {
        String msg = "sample msg 123 123   111 333 222";
        System.out.println(msg);
        Encoder.convertMsg(msg);
    }
}
