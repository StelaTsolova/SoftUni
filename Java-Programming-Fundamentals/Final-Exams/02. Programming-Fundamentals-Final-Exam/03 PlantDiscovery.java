import java.util.*;

public class PlantDiscovery_3_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> plants = new LinkedHashMap<>();

        for (int i = 0; i < lines; i++) {
            String[] plantInformation = scanner.nextLine().split("<->");
            String plantName = plantInformation[0];
            double rarity = Integer.parseInt(plantInformation[1]);
            plants.put(plantName, new ArrayList<>(Arrays.asList(rarity, 0.0)));
        }

        String input = scanner.nextLine();
        Map<String, List<Integer>> ratings = new LinkedHashMap<>();
        while (!input.equals("Exhibition")) {
            String[] command = input.split(": | - ");
            String plane = command[1];
            if (plants.containsKey(plane)) {
                switch (command[0]) {
                    case "Rate":
                        int rating = Integer.parseInt(command[2]);
                        ratings.putIfAbsent(plane, new ArrayList<>());
                        ratings.get(plane).add(rating);
                        break;
                    case "Update":
                        double newRarity = Integer.parseInt(command[2]);
                        plants.put(plane, new ArrayList<>(Arrays.asList(newRarity, 0.0)));
                        break;
                    case "Reset":
                        ratings.get(plane).clear();
                        break;
                }
            } else {
                System.out.println("error");
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<Integer>> entry : ratings.entrySet()) {
            String plane = entry.getKey();
            double sum = 0.0;
            for (int rating : entry.getValue()) {
                sum += rating;
            }
            if (sum != 0) {
                double averageSum = sum / entry.getValue().size();
                plants.get(plane).set(1, averageSum);
            }
        }
        System.out.println("Plants for the exhibition:");
        plants.entrySet().stream().sorted((r1, r2) -> r2.getValue().get(1).compareTo(r1.getValue().get(1)))
                .sorted((r3, r4) -> r4.getValue().get(0).compareTo(r3.getValue().get(0)))
                .forEach(e -> System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n", e.getKey(), e.getValue().get(0), e.getValue().get(1)));
    }
}