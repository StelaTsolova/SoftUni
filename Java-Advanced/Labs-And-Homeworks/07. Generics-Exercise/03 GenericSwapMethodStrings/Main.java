package GenericSwapMethodStrings_3;

import java.util.Arrays;
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
        int[] indices = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        box.swap(indices[0], indices[1]);

        System.out.println(box);
    }
}