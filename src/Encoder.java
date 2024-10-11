package src;

public class Encoder {
    // This class handles the encoding process, converting a plain text message into an encoded one

    //private String plainText;
    //private final String level1Encryption;

    // public Encoder(String plainText) {
    //   level1Encryption = matrixEncode(plainText);
    //}

    private static String matrixEncode(String plainText) {
        // Encodes the plain text by converting each character into a pair of characters using the matrix
        StringBuilder encrypted = new StringBuilder();
        for(char letter: plainText.toCharArray()) {
            encrypted.append(getPairFromMatrix(letter)); // Convert each letter into an encoded pair
        }
        return encrypted.toString(); // Return the complete encoded message
    }

    private static String getPairFromMatrix(char letter) {
        // This method finds a randomized "instance" of the letter using the matrix
        // It tells the MatrixManager to provide the number of ways the letter can be represented,
        // and then selects one of the available options at random
        int n = MatrixManager.getNumWays(letter); // Get number of ways to write the letter
        int randNum = (int)(Math.random() * n) + 1; // Pick a random instance from available options

        return MatrixManager.getCharPair(letter, randNum); // Return the encoded pair for the selected instance
    }

    public static String encodeMsg(String msgPlainText) {
        // Encodes the entire plain text message by converting each character into an encoded pair
        StringBuilder encodedLvl1 = new StringBuilder();

        for(char letter: msgPlainText.toCharArray()) {
            encodedLvl1.append(getPairFromMatrix(letter)); // Convert each letter and append to the result
        }

        return encodedLvl1.toString(); // Return the fully encoded message
    }

    public static void main(String[] args) {
        String msg = "something else"; // Example plain text message

        // Encode the message and print the encoded result
        String encoded = Encoder.encodeMsg(msg);
        System.out.println(encoded);
        // System.out.println(Decoder.decode(encoded));

        // Decoding a sample encoded string and printing the result
        System.out.println(Decoder.decode("g5RCR>%5153G1]1!>N1]g5A535{NANp2%23Cp2"));
    }
}