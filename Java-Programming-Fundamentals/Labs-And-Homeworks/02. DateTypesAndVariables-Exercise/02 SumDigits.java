import java.util.Scanner;

public class SumDigits_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int integer = Integer.parseInt(input);
        int sum = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            sum += integer % 10;
            integer = integer / 10;
        }
        System.out.println(sum);
    }
}