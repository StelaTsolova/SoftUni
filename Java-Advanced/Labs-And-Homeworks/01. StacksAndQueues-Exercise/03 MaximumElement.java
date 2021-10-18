import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lines; i++) {
            String command = scanner.nextLine();
            if (command.equals("2")) {
                numbers.pop();
            } else if (command.equals("3")) {
                if (!numbers.isEmpty()) {
                    System.out.println(Collections.max(numbers));
                } else {
                    System.out.println(0);
                }
            } else {
                String[] commandArray = command.split("\\s+");
                int num = Integer.parseInt(commandArray[1]);
                numbers.push(num);
            }
        }
    }
}