public class Encoder {
    //private String plainText;
    private String level1Encryption;

    // read input from user
    // convert to encoded message

    public Encoder(String plainText) {
        level1Encryption = matrixEncode(plainText);
    }

    private static String matrixEncode(String plainText) {
        String encrypted = "";
        for(char letter: plainText.toCharArray()) {
            encrypted += getPairFromMatrix(letter);
        }
        return encrypted;
    }

    private static String getPairFromMatrix(char letter) {
        return "";
    }
}
