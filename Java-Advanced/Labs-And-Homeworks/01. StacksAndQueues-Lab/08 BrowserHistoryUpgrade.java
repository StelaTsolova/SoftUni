import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> stackBack = new ArrayDeque<>();
        ArrayDeque<String> stackForward = new ArrayDeque<>();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (stackBack.size() > 1) {
                    stackForward.push(stackBack.pop());
                    System.out.println(stackBack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (input.equals("forward")) {
                if (stackForward.peek() == null){
                    System.out.println("no next URLs");
                } else {
                    System.out.println(stackForward.peek());
                    stackBack.push(stackForward.pop());
                }
            } else {
                stackBack.push(input);
                System.out.println(input);
                stackForward.clear();
            }
            input = scanner.nextLine();
        }
    }
}