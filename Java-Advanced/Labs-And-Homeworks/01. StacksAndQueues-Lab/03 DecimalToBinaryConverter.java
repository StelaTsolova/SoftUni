import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimalNumber = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();
        while (decimalNumber != 0) {
            int num = decimalNumber % 2;
            binaryNumber.push(num);
            decimalNumber /= 2;
        }
        if (binaryNumber.isEmpty()){
            System.out.println(0);
        } else {
            while (!binaryNumber.isEmpty()) {
                System.out.print(binaryNumber.pop());
            }
        }
    }
}