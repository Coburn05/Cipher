package src;
import java.util.ArrayList;
import java.util.List;

public class Decoder {
    // responsible for decoding
    //  - convert character pair to letter

    public static String decode(String encoded) {
        List<String> pairList = getPair(encoded);
        List<Integer[]> locList = getLocsOnMatrix(pairList);

        return "";
    }


    private static List<String> getPair(String encoded) {
        ArrayList<String> pairList = new ArrayList<>();
        for(int first = 0; first < encoded.length() - 1; first += 2) {
            int second = first + 1;

            pairList.add(String.valueOf(MatrixManager.getLetterFromPair(encoded.substring(first, second + 1))));
        }
        return pairList;
    }

    private static List<Integer[]> getLocsOnMatrix(List<String> list) {
        ArrayList<Integer[]> locationList = new ArrayList<>();

        for(String pair: list) {
            locationList.add(MatrixManager.getLocation(pair));
            for(Integer i: MatrixManager.getLocation(pair)) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        return locationList;
    }
}
