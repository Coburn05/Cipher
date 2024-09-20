package src;
import java.util.ArrayList;
import java.util.List;

public class Decoder {
    // responsible for decoding
    //  - convert character pair to letter

    public static void decode(String encoded) {
        List<String> pairList = getPair(encoded);
        List<Integer[]> locList = getLocsOnMatrix(pairList);
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

    // do i really need this?
    // i do not see a reason for this, can be replased with
    private static List<Integer[]> getLocsOnMatrix(List<String> list) {
        ArrayList<Integer[]> locationList = new ArrayList<>();

        for(String pair: list) {
            locationList.add(MatrixManager.getLocation(pair));
            for(Integer i: MatrixManager.getLocation(pair)) {
                System.out.println("Decoder getLocsOnMatrix");
            }
        }

        return locationList;
    }
}
