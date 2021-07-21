import java.util.Scanner;

public class FactorialDivision_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long firstNum = Long.parseLong(scanner.nextLine());
        long secondNum = Long.parseLong(scanner.nextLine());
        long firstNumFactorial = calculateFactorial(firstNum);
        long secondNumFactorial = calculateFactorial(secondNum);
        double result = calculateResult(firstNumFactorial, secondNumFactorial);
        System.out.printf("%.2f", result);
    }

    private static long calculateFactorial(long number) {
        long factorial = 1;
        for (long i = number; i > 1; i--) {
            factorial *= i;
        }
        return factorial;
    }

    private static double calculateResult(final double firstNumFactorial, final double secondNumFactorial) {
        return firstNumFactorial / secondNumFactorial;
    }
}