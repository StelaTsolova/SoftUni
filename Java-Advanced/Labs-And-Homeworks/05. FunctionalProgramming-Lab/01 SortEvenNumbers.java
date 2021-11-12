import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortEvenNumbers_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 4, 2, 1, 3, 5, 7, 1, 4, 2, 12
        int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0).toArray();

        Function<IntStream, String> formatNumbers = str -> str.mapToObj(String::valueOf).collect(Collectors.joining(", "));

        String functionalOutput = formatNumbers.apply(Arrays.stream(numbers));
        String sortedNumbers = formatNumbers.apply(Arrays.stream(numbers).sorted());

        System.out.println(functionalOutput);
        System.out.println(sortedNumbers);
    }
}