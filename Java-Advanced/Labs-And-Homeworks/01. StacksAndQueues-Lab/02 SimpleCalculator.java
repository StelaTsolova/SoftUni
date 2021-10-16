import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> numbers = new ArrayDeque<>();
        String[] expressionElements = scanner.nextLine().split("\\s+");
        for (int i = expressionElements.length - 1; i >= 0; i--) {
            numbers.push(expressionElements[i]);
        }
        while (numbers.size() > 2) {
          int leftNum = Integer.parseInt(numbers.pop());
          String operator = numbers.pop();
          int rightNum = Integer.parseInt(numbers.pop());
          int result = operator.equals("+")
                  ? leftNum + rightNum
                  : leftNum - rightNum;
          numbers.push(String.valueOf(result));
        }
        System.out.println(numbers.peek());
    }
}