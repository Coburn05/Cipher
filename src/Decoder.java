package src;
import java.util.ArrayList;
import java.util.List;

public class Decoder {
    // responsible for decoding
    //  - convert character pair to letter

    public static String decode(String encoded) {
        List<String> pairList = getPair(encoded);
        return decodeMsg(pairList).toString();
    }

    private static List<String> getPair(String encoded) {
        ArrayList<String> pairList = new ArrayList<>();
        for(int first = 0; first < encoded.length() - 1; first += 2) {
            int second = first + 1;

            // i know, it looks *soooo* good :)
            pairList.add(
                    String.valueOf(
                            MatrixManager.getLetterFromPair(
                                    encoded.substring(first, second + 1)
                            )
                    )
            );
        }
        return pairList;
    }

    private static String decodeMsg(List<String> list) {
        //ArrayList<Integer[]> locationList = new ArrayList<>();

        String msg = "";
        for(String str: list) {
            msg += str;
        }

        return msg;
    }
}
