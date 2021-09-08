import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber_5 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        BigInteger firstDigit = new BigInteger(scanner.nextLine());
        BigInteger secondDigit = new BigInteger(scanner.nextLine());
        BigInteger sum = firstDigit.multiply(secondDigit);
        System.out.println(sum);
    }
}