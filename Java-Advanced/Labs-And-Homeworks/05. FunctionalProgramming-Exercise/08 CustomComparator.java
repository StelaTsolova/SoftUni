import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Comparator<Integer> sortNum = (x1, x2) -> {
            if (x1 % 2 == 0 && x2 % 2 != 0) {
                return -1;
            } else if (x1 % 2 != 0 && x2 % 2 == 0) {
                return 1;
            } else {
                if (x1 > x2) {
                    return 1;
                }
                return -1;
            }
        };
        numbers.sort(sortNum);
        numbers.forEach(n -> System.out.print(n + " "));
    }
}