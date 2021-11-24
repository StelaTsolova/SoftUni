package GenericBoxOfInteger_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();
        while (lines-- > 0) {
            int element = Integer.parseInt(scanner.nextLine());
            box.add(element);
        }
        System.out.println(box);
    }
}