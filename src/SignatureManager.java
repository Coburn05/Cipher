package src;

public class SignatureManager {
    // handles actions relating to signatures
    //  generates signatures based on keys
    //  locates and extracts information
    //  handles verification of signature

    private static String senderID = "some super secret string like this one";
    private static String senderHash = "should be a hash";

    public static boolean verifyMsg(String msg, String signature, int msgNum) {
        // will have to verify senderID from hash
        // will have to get new rolling code for the message
        // will have to compare hash of rolling code+senderID to given signature
        //   - excluding header information (first 9 characters designating matrix transformations)

        return false;
    }

    private static int computeRollingCode(int msgNum) {
        // using some function compute the rolling code for the given msgNumber
        return -1;
    }

    private static boolean verifySenderID(String givenHash) {
        // not sure if this functionality is needed
        // msg verification complex enough as is, this is making things harder 
        return false;
    }
}
