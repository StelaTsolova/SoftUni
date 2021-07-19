import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations_11 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        double firstNum = Double.parseDouble(scanner.nextLine());
         char operator = scanner.nextLine().charAt(0);
        double secondNum = Double.parseDouble(scanner.nextLine());
         DecimalFormat result = new DecimalFormat("0.##");
        System.out.println(result.format(calculatesResult(firstNum, operator, secondNum)));
    }

    private static double calculatesResult(double firstNum, char operator, double secondNum) {
        double result = 0.0;
        switch (operator){
            case '/':
                result = firstNum / secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
        }
        return result;
    }
}
