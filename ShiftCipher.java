public class ShiftCipher {
    public static StringBuffer encrypt(String message, int shift) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < message.length(); i++) {
            if (Character.isUpperCase(message.charAt(i))) {
                char ch = (char) (((int) message.charAt(i) + shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) message.charAt(i) + shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    public static StringBuffer decrypt(String message, int shift) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < message.length(); i++) {
            if (Character.isUpperCase(message.charAt(i))) {
                char ch = (char) (((int) message.charAt(i) - shift - 65 + 26) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) message.charAt(i) - shift - 97 + 26) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "ETHANHUNT";
        int shift = 4;
        System.out.println("Original Message: " + str);
        System.out.println("Shift: " + shift);
        System.out.println("Encrypted Message: " + encrypt(str, shift));
        String e = encrypt(str, shift).toString();
        System.out.println("Decrypted Message: " + decrypt(e, shift));
    }
}