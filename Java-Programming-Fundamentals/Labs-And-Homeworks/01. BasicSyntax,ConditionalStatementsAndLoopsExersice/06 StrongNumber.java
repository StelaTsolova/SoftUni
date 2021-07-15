import java.util.Scanner;

public class StrongNumber_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int totalSum = 0;
        for (int i = 0; i < input.length(); i++) {
            int num = Integer.parseInt(""+ input.charAt(i));
            int sum = 1;
            for (int j = num; j >= 1; j--) {
                sum *= j;
            }
            totalSum += sum;
        }
        int number = Integer.parseInt(input);
        if (number == totalSum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}