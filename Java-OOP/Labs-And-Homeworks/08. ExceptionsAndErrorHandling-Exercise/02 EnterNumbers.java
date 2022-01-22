import java.util.Scanner;
import java.util.stream.IntStream;

public class EnterNumbers_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int start = Integer.parseInt(scanner.nextLine());
                int end = Integer.parseInt(scanner.nextLine());

                printNumbers(start, end);
                break;
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void printNumbers(int start, int end) {
        if (!(1 < start && start < end && end < 100)) {
            throw new NumberFormatException("Invalid range");
        }

        IntStream.rangeClosed(start, end).forEach(System.out::println);
    }
}
