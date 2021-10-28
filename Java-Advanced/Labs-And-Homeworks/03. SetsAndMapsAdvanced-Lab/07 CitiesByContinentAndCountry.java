import java.util.*;

public class CitiesByContinentAndCountry_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> information = new LinkedHashMap<>();
        while (lines-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];
            information.putIfAbsent(continent, new LinkedHashMap<>());
            information.get(continent).putIfAbsent(country, new ArrayList<>());
            information.get(continent).get(country).add(city);

        }
        information.forEach((k, e) ->{
            System.out.println(k + ":");
            e.forEach((k1, v) ->{
                System.out.print(k1 + " -> ");
                System.out.print(String.join(", ", v));
                System.out.println();
            });
        });
    }
}