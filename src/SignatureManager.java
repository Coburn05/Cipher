package src;

/*
ideas on how this could be done
RSA will be used unless a better alternative can be found
RSA keys
  - not super hard to break into

Pass phrase, add character integer values to signature
would result in completed signature?
 - would not be the "intuitive" approach but would only work if you have both
   parts of the message correct

don't use signatures all together
 - instead have the handshake establish encryption
 - until a new key is requested by the sender
 - this would work only one way, so for two parties to send AND revive
 - there would be 2 ciphers
 -- issue i see with this is that if encryption happens to be broken, then the new key can
    also be compromised
 */

public class SignatureManager {
    // Handles actions related to signatures:
    //  - Generates signatures based on keys
    //  - Locates and extracts relevant information
    //  - Verifies the authenticity of a given signature

    private static String senderID = "some super secret string like this one";
    private static String senderHash = "should be a hash";

    // Method to verify the integrity and authenticity of a message based on its signature
    public static boolean verifyMsg(String msg, String signature, int msgNum) {
        // Will verify senderID using the hash
        // Generate a new rolling code for the message (likely based on msgNum)
        // Combine the rolling code and senderID, hash it, and compare with the given signature
        // Exclude the header information (first 9 characters that represent matrix transformations)

        return false;
    }

    // Method to compute a rolling code based on the message number (msgNum)
    private static int computeRollingCode(int msgNum) {
        // Use some formula or algorithm to compute the rolling code for the given msgNumber
        return -1;
    }

    // Method to verify if the given sender's hash matches the expected senderHash
    private static boolean verifySenderID(String givenHash) {
        // It's uncertain if this functionality will be needed
        // Message verification is already complex, and this might add unnecessary difficulty
        return false;
    }
}