import java.util.Scanner;

public class CaesarCipher_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String encryptedText = encryptsText(text);
        System.out.println(encryptedText);
    }

    private static String encryptsText(String text) {
        StringBuilder encryptedText = new StringBuilder();
        for (Character symbol : text.toCharArray()) {
            encryptedText.append((char)(symbol + 3));
        }
        return encryptedText.toString();
    }
}