import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lines; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String num = command[0];
            switch (num) {
                case "1":
                    stack.push(text.toString());
                    String string = command[1];
                    text.append(string);
                    break;
                case "2":
                    stack.push(text.toString());
                    int count = Integer.parseInt(command[1]);
                    int start = text.length() - count;
                    text.delete(start, start + count);
                    break;
                case "3":
                    int index = Integer.parseInt(command[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    if (!stack.isEmpty()) {
                        text = new StringBuilder(stack.pop());
                    }
                    break;
            }
        }
    }
}