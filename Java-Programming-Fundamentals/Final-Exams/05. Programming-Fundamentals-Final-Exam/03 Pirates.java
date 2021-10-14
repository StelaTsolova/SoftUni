import java.util.*;

public class Pirates_3_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Integer>> settlements = new TreeMap<>();
        String command = scanner.nextLine();
        while (!command.equals("Sail")) {
            String[] information = command.split("[\\|]{2}");
            String town = information[0];
            int population = Integer.parseInt(information[1]);
            int gold = Integer.parseInt(information[2]);
            if (settlements.containsKey(town)) {
                settlements.get(town).set(0, settlements.get(town).get(0) + population);
                settlements.get(town).set(1, settlements.get(town).get(1) + gold);
                command = scanner.nextLine();
                continue;
            }
            settlements.put(town, new ArrayList<>(Arrays.asList(population, gold)));

            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] event = command.split("=>");
            String town = event[1];
            switch (event[0]) {
                case "Plunder":
                    int people = Integer.parseInt(event[2]);
                    int gold = Integer.parseInt(event[3]);
                    settlements.get(town).set(0, settlements.get(town).get(0) - people);
                    settlements.get(town).set(1, settlements.get(town).get(1) - gold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                if (settlements.get(town).get(0) <= 0 || settlements.get(town).get(1) <= 0) {
                    settlements.remove(town);
                    System.out.printf("%s has been wiped off the map!%n", town);
                }
                break;
                case "Prosper":
                    int gold2 = Integer.parseInt(event[2]);
                    if (gold2 < 0){
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        int newGold = settlements.get(town).get(1) + gold2;
                        settlements.get(town).set(1, newGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold2, town, newGold);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        if (settlements.isEmpty()){
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", settlements.values().size());
            settlements.entrySet().stream().sorted((g1, g2) ->
                (Integer.compare(g2.getValue().get(1), g1.getValue().get(1))))
                    .forEach(e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", e.getKey(),e.getValue().get(0), e.getValue().get(1)));
        }
    }
}