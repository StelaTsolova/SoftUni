import java.util.Scanner;

public class MultiplyEvensByOdds_10 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int number = Math.abs(Integer.parseInt(scanner.nextLine()));
        System.out.println(getMultipleOfEvensAndOdds(number));
    }

    private static int getMultipleOfEvensAndOdds(int number) {
       int evensSum = calculatesEvensDigit(number);
       int oddsSum = calculatesOddsDigit(number);
       return evensSum * oddsSum;
    }


    private static int calculatesEvensDigit(int number) {
        int evenSum = 0;
        while (number > 0){
            int digit = number % 10;
            if (digit % 2 == 0){
                evenSum += digit;
            }
            number /= 10;
        }
        return evenSum;
    }

    private static int calculatesOddsDigit(int number) {
        int oddSum = 0;
        while (number > 0){
            int digit = number % 10;
            if (digit % 2 != 0){
                oddSum += digit;
            }
            number /= 10;
        }
        return oddSum;
    }
}