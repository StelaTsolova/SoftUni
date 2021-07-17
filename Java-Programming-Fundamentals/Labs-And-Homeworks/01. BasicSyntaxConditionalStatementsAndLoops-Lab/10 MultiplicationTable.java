import java.util.Scanner;

public class MultiplicationTable_10 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int theInteger = Integer.parseInt(scanner.nextLine());
         for (int i = 1; i <= 10; i++) {
         int product = theInteger * i;
             System.out.printf("%d X %d = %d%n", theInteger, i, product);
         }
    }
}
