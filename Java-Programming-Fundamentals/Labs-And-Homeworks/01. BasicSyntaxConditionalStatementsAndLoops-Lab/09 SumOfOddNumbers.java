import java.util.Scanner;

public class SumOfOddNumbers_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int oddNum = n;
        int num = 1;
        while (oddNum > 0) {
            if (num % 2 != 0) {
                System.out.println(num);
                sum += num;
                oddNum--;
            }
            num++;
        }
        System.out.printf("Sum: %d", sum);
    }
}
