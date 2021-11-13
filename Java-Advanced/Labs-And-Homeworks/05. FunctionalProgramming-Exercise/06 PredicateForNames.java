import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthLimit = Integer.parseInt(scanner.nextLine());

        Predicate<String> checkLength = w -> w.length() <= lengthLimit;
        Arrays.stream(scanner.nextLine().split("\\s+")).filter(checkLength).forEach(System.out::println);
    }
}