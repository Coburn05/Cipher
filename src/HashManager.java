package src;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class HashManager {

    // Method to generate a random string of a specified length
    public static String generateRandomString(int length) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[length]; // Create a byte array of the given length
        random.nextBytes(bytes); // Fill the array with random bytes
        return Base64.getEncoder().encodeToString(bytes); // Encode the bytes as a base64 string
        // Encoding as base64 string
    }

    // Method to hash the input string using SHA-256
    public static String hashString(String input)
            throws NoSuchAlgorithmException {

        MessageDigest digest =
                MessageDigest.getInstance("SHA-256"); // Initialize the SHA-256 hashing algorithm

        byte[] hashBytes = digest.digest(input.getBytes()); // Hash the input string
        return bytesToHex(hashBytes); // Convert the hashed bytes to a hexadecimal string
    }

    // Method to convert byte array to hexadecimal format
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(); // Initialize a string builder for hexadecimal conversion
        for (byte b : bytes) {
            sb.append(String.format("%02x", b)); // Convert each byte to a hex value
        }
        return sb.toString(); // Return the full hex string
    }

    public static void main(String[] args) {
        try {
            // Generate random string
            String randomString = generateRandomString(16); // Generate a random 16-byte string
            System.out.print("Random String: ");
            System.out.println(randomString);

            // Hash the random string
            String hashedString = hashString(randomString); // Hash the generated random string
            System.out.println("Hashed String (SHA-256): ");
            System.out.println(hashedString);

        } catch (NoSuchAlgorithmException e) {
            // Handle exception in case the SHA-256 algorithm is not available
            System.out.print("Error: ");
            System.out.println(e.getMessage());
        }
    }
}