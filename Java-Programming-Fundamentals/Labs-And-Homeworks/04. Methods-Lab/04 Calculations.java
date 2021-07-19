import java.util.Scanner;

public class Calculations_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        switch (action) {
            case "add":
                printSum(firstNum, secondNum);
                break;
            case "multiply":
                printProduct(firstNum, secondNum);
                break;
            case "subtract":
                printDifference(firstNum, secondNum);
                break;
            case "divide":
                printRemnant(firstNum, secondNum);
                break;
        }
    }

    private static void printSum(int firstNum, int secondNum) {
        System.out.println(firstNum + secondNum);
    }

    private static void printProduct(int firstNum, int secondNum) {
        System.out.println(firstNum * secondNum);
    }

    private static void printDifference(int firstNum, int secondNum) {
        System.out.println(firstNum - secondNum);
    }

    private static void printRemnant(int firstNum, int secondNum) {
        System.out.println(firstNum / secondNum);
    }
}