import java.util.Scanner;

public class TopNumber_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        checkNumOneToN(n);
    }

    private static void checkNumOneToN(int n) {
        for (int i = 1; i <= n; i++) {
            String number = String.valueOf(i);
            int sumDijitsToNumber = 0;
            boolean haveOddDigit = false;
            for (int j = 0; j < number.length(); j++) {
                int curentDijit = Integer.parseInt(Character.toString(number.charAt(j)));
                sumDijitsToNumber += curentDijit;
                if (!haveOddDigit){
                    haveOddDigit = checkForOddDigits(curentDijit);
                }
            }
            boolean sumOfDigitsDivisibleBy8 = checkSumOfDigits(sumDijitsToNumber);
            if (haveOddDigit && sumOfDigitsDivisibleBy8){
                printTopNumber(i);
            }
        }
    }

    private static boolean checkForOddDigits(int curentDigit) {
        return curentDigit % 2 != 0;
    }

    private static boolean checkSumOfDigits(int sumDijitsToNumber) {
        return sumDijitsToNumber % 8 == 0;
    }

    private static void printTopNumber(int topNumber) {
        System.out.println(topNumber);
    }
}