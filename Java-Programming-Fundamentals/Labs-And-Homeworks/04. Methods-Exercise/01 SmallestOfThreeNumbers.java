import java.util.Scanner;

public class SmallestOfThreeNumbers_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        printSmallestNumber(firstNumber, secondNumber, thirdNumber);
    }

    private static void printSmallestNumber(int firstNumber, int secondNumber, int thirdNumber) {
        if (firstNumber <= secondNumber && firstNumber <= thirdNumber) {
            System.out.println(firstNumber);
        } else if (secondNumber <= firstNumber && secondNumber <= thirdNumber) {
            System.out.println(secondNumber);
        } else if (thirdNumber <= firstNumber && thirdNumber <= secondNumber) {
            System.out.println(thirdNumber);
        }
    }
}