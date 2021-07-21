import java.util.Scanner;

public class AddAndSubtract_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        int sum = calculaterSum(firstNumber, secondNumber);
        int result = calculaterSubtract(sum, thirdNumber);
        System.out.println(result);
    }

    private static int calculaterSum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    private static int calculaterSubtract(int sum, int thirdNumber) {
        return sum - thirdNumber;
    }
}