import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, int[]>> statistics = new LinkedHashMap<>();
        Map<String, double[]> averageData = new LinkedHashMap<>();
        while (lines-- > 0) {
            String[] information = scanner.nextLine().split("\\s+");
            String type = information[0];
            String name = information[1];
            int damage = getStat(information, 2);
            int health = getStat(information, 3);
            int armor = getStat(information, 4);

            statistics.putIfAbsent(type, new TreeMap<>());
            statistics.get(type).putIfAbsent(name, new int[3]);
            statistics.get(type).get(name)[0] = damage;
            statistics.get(type).get(name)[1] = health;
            statistics.get(type).get(name)[2] = armor;

            averageData.putIfAbsent(type, new double[3]);
        }
        fillAverageDate(statistics, averageData);
        statistics.entrySet().forEach(e -> {
            double damage = averageData.get(e.getKey())[0];
            double health = averageData.get(e.getKey())[1];
            double armor = averageData.get(e.getKey())[2];
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", e.getKey(), damage, health, armor);
            e.getValue().forEach((k, v) -> {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", k, v[0], v[1], v[2]);
            });
        });
    }

    private static void fillAverageDate(Map<String, Map<String, int[]>> statistics, Map<String, double[]> averageData) {
        for (Map.Entry<String, Map<String, int[]>> entry : statistics.entrySet()) {
            int totalDamage = 0;
            int totalHealth = 0;
            int totalArmor = 0;
            for (Map.Entry<String, int[]> value : entry.getValue().entrySet()) {
                totalDamage += value.getValue()[0];
                totalHealth += value.getValue()[1];
                totalArmor += value.getValue()[2];
            }
            double averageDamage = totalDamage / (double) entry.getValue().size();
            double averageHealth = totalHealth / (double) entry.getValue().size();
            double averageArmor = totalArmor / (double) entry.getValue().size();
            averageData.get(entry.getKey())[0] = averageDamage;
            averageData.get(entry.getKey())[1] = averageHealth;
            averageData.get(entry.getKey())[2] = averageArmor;
        }
    }

    private static int getStat(String[] information, int index) {
        if (information[index].equals("null")) {
            if (index == 2) {
                return 45;
            }
            if (index == 3) {
                return 250;
            }
            if (index == 4) {
                return 10;
            }
        }
        return Integer.parseInt(information[index]);
    }
}