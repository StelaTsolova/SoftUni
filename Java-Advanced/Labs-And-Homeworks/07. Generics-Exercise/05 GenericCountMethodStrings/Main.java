package GenericCountMethodStrings_5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();
        while (lines-- > 0) {
            String element = scanner.nextLine();
            box.add(element);
        }
        String comparedItem = scanner.nextLine();

        System.out.println(box.countedGreaterThan(comparedItem));
    }
}