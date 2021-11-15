import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOfPredicates_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int endNum = Integer.parseInt(scanner.nextLine());
        int[] dividers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Predicate<Integer> checkNum = n -> isValid(n, dividers);
        Arrays.stream(IntStream.rangeClosed(1, endNum).toArray()).boxed().filter(checkNum).forEach(n -> System.out.print(n + " "));
    }

    private static boolean isValid(Integer n, int[] dividers) {
        for (int divider : dividers) {
            if (n % divider != 0) {
                return false;
            }
        }
        return true;
    }
}