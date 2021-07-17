import java.util.Scanner;

public class SumOfChars_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
           char symbol = scanner.nextLine().charAt(0);
           sum += symbol;
        }
        System.out.println(String.format("The sum equals: %d", sum));
    }
}