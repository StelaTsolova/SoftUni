import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizeSets = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int sizeFirstSet = sizeSets[0];
        int sizeSecondSet = sizeSets[1];
        Set<Integer> firstSet = new LinkedHashSet<>(sizeFirstSet);
        Set<Integer> secondSet = new LinkedHashSet<>(sizeSecondSet);
        while (sizeFirstSet-- > 0) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }
        while (sizeSecondSet-- > 0) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }
        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));
    }
}