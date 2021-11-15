import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElement_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<Integer[], Integer> getIndexOfMinNum = a -> {
            int minNum = Integer.MAX_VALUE;
            int indexOfMinNum = -1;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= minNum) {
                    minNum = a[i];
                    indexOfMinNum = i;
                }
            }
            return indexOfMinNum;
        };

        int indexOfMinNum = getIndexOfMinNum.apply(Arrays.stream(numbers).boxed().toArray(Integer[]::new));
        System.out.println(indexOfMinNum);
    }
}