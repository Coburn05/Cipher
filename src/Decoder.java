package src;
import java.util.ArrayList;
import java.util.List;

public class Decoder {
    // This class is responsible for decoding an encoded message
    // The decoding involves converting character pairs back into letters

    public static String decode(String encoded) {
        // Takes the encoded string and decodes it to the original message
        List<String> pairList = getPair(encoded); // Extract character pairs from encoded message
        return decodeMsg(pairList).toString(); // Return the decoded message
    }

    private static List<String> getPair(String encoded) {
        // This method splits the encoded string into character pairs and decodes each pair using the MatrixManager

        ArrayList<String> pairList = new ArrayList<>();
        for(int first = 0; first < encoded.length() - 1; first += 2) {
            int second = first + 1;

            // Decoding each pair and adding the result to pairList
            pairList.add(
                    String.valueOf(
                            MatrixManager.getLetterFromPair(
                                    encoded.substring(first, second + 1) // Extract 2-character substring
                            )
                    )
            );
        }
        return pairList; // Returns list of decoded letters
    }

    private static String decodeMsg(List<String> list) {
        // This method combines the list of decoded letters back into a full message
        //ArrayList<Integer[]> locationList = new ArrayList<>();
        String msg = "";
        for(String str: list) {
            msg += str; // Concatenates each decoded letter to form the final message
        }

        return msg; // Returns the decoded message
    }
}
