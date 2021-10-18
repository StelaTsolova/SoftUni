import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            numbers.push(scanner.nextInt());
        }
        for (int i = 0; i < s; i++) {
            numbers.pop();
        }
        if (!numbers.isEmpty()) {
            if (numbers.contains(x)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(numbers));
            }
        } else {
            System.out.println(0);
        }
    }
}