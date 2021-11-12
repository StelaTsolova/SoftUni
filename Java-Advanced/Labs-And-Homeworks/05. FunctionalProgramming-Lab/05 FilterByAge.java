import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> statistic = new LinkedHashMap<>();
        while (lines-- > 0) {
            String[] information = scanner.nextLine().split(", ");
            String name = information[0];
            int age = Integer.parseInt(information[1]);
            statistic.put(name, age);
        }
        String condition = scanner.nextLine();
        int ageCondition = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Map.Entry<String, Integer>> ageFilter = getAgeFilter(condition, ageCondition);
        Consumer<Map.Entry<String, Integer>> output = getOutput(format);
        statistic.entrySet().stream().filter(ageFilter).forEach(output);
    }

    private static Predicate<Map.Entry<String, Integer>> getAgeFilter(String condition, int ageCondition) {
        if (condition.equals("older")) {
            return e -> e.getValue() >= ageCondition;
        }
        return e -> e.getValue() <= ageCondition;
    }

    private static Consumer<Map.Entry<String, Integer>> getOutput(String format) {
        if (format.equals("name")) {
            return e -> System.out.println(e.getKey());
        } else if (format.equals("age")) {
            return e -> System.out.println(e.getValue());
        }
        return e -> System.out.println(e.getKey() + " - " + e.getValue());
    }
}