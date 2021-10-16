import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        int num = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String name : names) {
            queue.offer(name);
        }
        int counter = 0;
        while (queue.size() > 1) {
            counter++;
            for (int i = 1; i < num; i++) {
                queue.offer(queue.poll());
            }
            if (!isPrime(counter) || counter == 1) {
                System.out.println("Removed " + queue.poll());
            } else {
                System.out.println("Prime " + queue.peek());
            }
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int num) {
        boolean isPrime = true;
        for (int j = 2; j < num; j++) {
            if (num % j == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}