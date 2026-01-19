import java.security.MessageDigest;
import java.util.Scanner;

public class MD5ndSHA1 {

    public static String generateHash(String input, String algorithm) throws Exception {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] hashBytes = md.digest(input.getBytes());

        StringBuilder hash = new StringBuilder();
        for (byte b : hashBytes) {
            hash.append(String.format("%02x", b));
        }
        return hash.toString();
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a message: ");
        String message = sc.nextLine();

        long startMD5 = System.nanoTime();
        String md5Hash = generateHash(message, "MD5");
        long endMD5 = System.nanoTime();
        long md5Time = endMD5 - startMD5;

        long startSHA1 = System.nanoTime();
        String sha1Hash = generateHash(message, "SHA-1");
        long endSHA1 = System.nanoTime();
        long sha1Time = endSHA1 - startSHA1;

        System.out.println("\n--- Hash Output for Given Input ---");
        System.out.println("Input Message : " + message);
        System.out.println("MD5  Hash     : " + md5Hash);
        System.out.println("SHA-1 Hash    : " + sha1Hash);

        System.out.println("\n--- Comparison Table (Actual Output & Speed) ---");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("%-25s %-35s %-35s%n", "Comparison Point", "MD5", "SHA-1");
        System.out.println("------------------------------------------------------------------------------------------------");
       
        System.out.printf("%-25s %-35s %-35s%n",
                "1. Output Hash Size",
                md5Hash.length() * 4 + " bits",
                sha1Hash.length() * 4 + " bits");

        System.out.printf("%-25s %-35s %-35s%n",
                "2. Security Level",
                "Very Weak",
                "Weak");

        System.out.printf("%-25s %-35s %-35s%n",
                "3. Speed (Time Taken)",
                md5Time + " ns",
                sha1Time + " ns");

        System.out.printf("%-25s %-35s %-35s%n",
                "5. Collision Resistance",
                "Poor",
                "Better than MD5");

        System.out.printf("%-25s %-35s %-35s%n",
                "6. Algorithm Complexity",
                "Simple",
                "More Complex");

        System.out.printf("%-25s %-35s %-35s%n",
                "Actual Hash Output",
                md5Hash,
                sha1Hash);

        System.out.println("------------------------------------------------------------------------------------------------");

        sc.close();
    }
}
