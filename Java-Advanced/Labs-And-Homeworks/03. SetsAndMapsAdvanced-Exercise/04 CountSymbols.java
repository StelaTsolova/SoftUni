import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> countSymbols = new TreeMap<>();
        String input = scanner.nextLine();
        for (char symbol : input.toCharArray()) {
            countSymbols.putIfAbsent(symbol, 0);
            countSymbols.put(symbol, countSymbols.get(symbol) + 1);
        }
        countSymbols.forEach((k, v) -> System.out.printf("%s: %d time/s%n", k, v));
    }
}