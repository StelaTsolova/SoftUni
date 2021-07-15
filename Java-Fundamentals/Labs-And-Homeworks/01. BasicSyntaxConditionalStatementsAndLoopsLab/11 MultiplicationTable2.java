import java.util.Scanner;

public class MultiplicationTable2_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int theInteger = Integer.parseInt(scanner.nextLine());
        int starNum2 = Integer.parseInt(scanner.nextLine());
        if (starNum2 <= 10) {
            for (int i = starNum2; i <= 10; i++) {
                int product = theInteger * i;
                System.out.printf("%d X %d = %d%n", theInteger, i, product);
            }
        } else {
            int result = theInteger * starNum2;
            System.out.printf("%d X %d = %d%n", theInteger, starNum2, result);
        }
    }
}
