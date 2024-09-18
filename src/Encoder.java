package src;

public class Encoder {
    //private String plainText;
    //private final String level1Encryption;

    // read input from user
    // convert to encoded message

    //public Encoder(String plainText) {
     //   level1Encryption = matrixEncode(plainText);
    //}

    //public String getLevel1Message() {
     //   return level1Encryption;
    //}

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

    public static String encodeMsg(String msgPlainText) {
        StringBuilder encodedLvl1 = new StringBuilder();

        for(char letter: msgPlainText.toCharArray()) {
            encodedLvl1.append(getPairFromMatrix(letter));
        }

        return encodedLvl1.toString();
    }

    public static void main(String[] args) {
        String msg = "msg ABC 123 !@#";

        String encoded = Encoder.encodeMsg(msg);
        String encoded1 = Encoder.encodeMsg(msg);
        String encoded2 = Encoder.encodeMsg(msg);

        System.out.println(msg);
        System.out.println(encoded);
        System.out.println(encoded1);
        System.out.println(encoded2);

        //Decoder.decode(encoded);
    }
}
