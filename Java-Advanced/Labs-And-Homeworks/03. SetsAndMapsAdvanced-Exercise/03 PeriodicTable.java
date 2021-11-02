import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Set<String> chemicalElements = new TreeSet<>();
        while (lines-- > 0) {
            String[] chemicalCompounds = scanner.nextLine().split("\\s+");
            chemicalElements.addAll(Arrays.asList(chemicalCompounds));
        }
        chemicalElements.forEach(e -> System.out.print(e + " "));
    }
}