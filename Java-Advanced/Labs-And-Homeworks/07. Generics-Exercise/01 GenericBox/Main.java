package GenericBox_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();
        while (lines-- > 0) {
            box.add(scanner.nextLine());
        }
        System.out.println(box);
    }
}