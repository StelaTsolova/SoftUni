import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> output = new LinkedHashMap<>();
        for (double number : numbers) {
            output.putIfAbsent(number, 0);
            output.put(number, output.get(number) + 1);
        }
        output.forEach((k, v) -> System.out.printf("%.1f -> %d%n", k, v));
    }
}