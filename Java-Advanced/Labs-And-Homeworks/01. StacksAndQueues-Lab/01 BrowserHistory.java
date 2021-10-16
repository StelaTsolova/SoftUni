import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> URLs = new ArrayDeque<>();
        String command = scanner.nextLine();
        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (URLs.size() > 1) {
                    URLs.pop();
                    System.out.println(URLs.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                URLs.push(command);
                System.out.println(command);
            }

            command = scanner.nextLine();
        }
    }
}