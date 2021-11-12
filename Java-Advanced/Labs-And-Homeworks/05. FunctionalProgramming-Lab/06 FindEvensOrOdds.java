import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] range = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int startNum = range[0];
        int endNum = range[1];
        String condition = scanner.nextLine();

        Predicate<Integer> numFilter = getNumFilter(condition);
        Consumer<Integer> output = e -> System.out.print(e + " ");
        IntStream.rangeClosed(startNum, endNum).boxed().filter(numFilter).forEach(output);
    }

    private static Predicate<Integer> getNumFilter(String condition) {
        if (condition.equals("odd")){
            return n -> n % 2 != 0;
        }
        return  n -> n % 2 == 0;
    }
}