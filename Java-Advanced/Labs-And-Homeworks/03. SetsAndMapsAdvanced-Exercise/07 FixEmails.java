import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> namesAndEmails = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String email = scanner.nextLine();
            boolean isValidEmail = checkEmail(email);
            if (isValidEmail) {
                namesAndEmails.put(input, email);
            }
            input = scanner.nextLine();
        }
        namesAndEmails.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    private static boolean checkEmail(String email) {
        return !email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com");
    }
}