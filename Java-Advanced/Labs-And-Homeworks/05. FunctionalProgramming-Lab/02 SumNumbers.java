import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SumNumbers_2 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        Function<IntStream, Long> countNumbers = str -> str.count();
        Function<IntStream, Integer> sumNumbers = str -> str.sum();

        System.out.println("Count = " + countNumbers.apply(Arrays.stream(numbers)));
        System.out.println("Sum = " + sumNumbers.apply(Arrays.stream(numbers)));
    }
}