import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class HashManager {

    // Method to generate a random string
    public static String generateRandomString(int length) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);  // Encoding as base64 string
    }

    // Method to hash the input string using SHA-256
    public static String hashString(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(input.getBytes());
        return bytesToHex(hashBytes);
    }

    // Method to convert byte array to hexadecimal format
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            // Generate random string
            String randomString = generateRandomString(16);
            System.out.println("Random String: " + randomString);

            // Hash the random string
            String hashedString = hashString(randomString);
            System.out.println("Hashed String (SHA-256): " + hashedString);

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
