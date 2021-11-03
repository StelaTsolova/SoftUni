import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Long>> statistics = new LinkedHashMap<>();
        Map<String, Long> totalPopulation = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("report")) {
            String[] information = input.split("\\|");
            String city = information[0];
            String country = information[1];
            long population = Long.parseLong(information[2]);
            statistics.putIfAbsent(country, new LinkedHashMap<>());
            totalPopulation.putIfAbsent(country, (long) 0);
            statistics.get(country).putIfAbsent(city, (long) 0);
            statistics.get(country).put(city, statistics.get(country).get(city) + population);
            totalPopulation.put(country, totalPopulation.get(country) + population);
            input = scanner.nextLine();
        }

        totalPopulation.entrySet().stream().sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue())).forEach(e -> {
            System.out.printf("%s (total population: %d)%n", e.getKey(), e.getValue());
            statistics.get(e.getKey()).entrySet().stream().sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue())).forEach((c -> {
                System.out.printf("=>%s: %d%n", c.getKey(), c.getValue());
            }));
        });
    }
}