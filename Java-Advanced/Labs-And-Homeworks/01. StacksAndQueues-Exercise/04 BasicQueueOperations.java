import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            numbers.offer(scanner.nextInt());
        }
        for (int i = 0; i < s; i++) {
            numbers.poll();
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