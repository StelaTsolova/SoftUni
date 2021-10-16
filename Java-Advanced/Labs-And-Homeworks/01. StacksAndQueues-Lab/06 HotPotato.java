import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato_6 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String[] names = scanner.nextLine().split("\\s+");
         int num = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String name:names){
            queue.offer(name);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < num; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}