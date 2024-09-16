package src;
import java.util.ArrayList;
import java.util.List;

public class Decoder {
    // responsible for decoding
    //  - convert character pair to letter

    public static List<String> decode(String encoded) {
        ArrayList<String> pairList = new ArrayList<>();
        for(int first = 0; first < encoded.length() - 1; first += 2) {
            int second = first + 1;

            pairList.add(String.valueOf(MatrixManager.getLetterFromPair(encoded.substring(first, second + 1))));
        }
        return pairList;
    }
}
