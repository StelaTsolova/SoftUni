import java.util.Scanner;

public class PalindromeIntegers_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            boolean isPalindromeNumber = cheksNumber(input);
            System.out.println(isPalindromeNumber);
            input = scanner.nextLine();
        }
    }

    private static boolean cheksNumber(String number) {
        return number.charAt(0) == number.charAt(number.length() - 1);
    }
}