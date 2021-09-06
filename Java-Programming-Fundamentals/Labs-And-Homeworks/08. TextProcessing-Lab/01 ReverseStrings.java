import java.util.Scanner;

public class ReverseStrings_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            StringBuilder reverseWord = new StringBuilder();
            for (int i = input.length() - 1; i >= 0; i--) {
                reverseWord.append(input.charAt(i));
            }
            System.out.printf("%s = %s%n", input, reverseWord);
            input = scanner.nextLine();
        }
    }
}