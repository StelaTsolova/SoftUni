import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt_2_6August2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> initialLoot = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("Yohoho!")) {
            switch (command[0]) {
                case "Loot":
                    for (int i = 1; i < command.length; i++) {
                        String item = command[i];
                        if (!initialLoot.contains(item)) {
                            initialLoot.add(0, item);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(command[1]);
                    if (index >= 0 && index < initialLoot.size()) {
                        String loop = initialLoot.get(index);
                        initialLoot.remove(index);
                        initialLoot.add(loop);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(command[1]);
                    if (count >= initialLoot.size()) {
                        System.out.println(initialLoot.toString().replaceAll("[\\[\\]]", ""));
                        initialLoot.clear();
                    } else {
                        List<String> stealLoops = new ArrayList<>();
                        int startIndex = initialLoot.size() - count;
                        for (int i = 0; i < count; i++) {
                            stealLoops.add(initialLoot.get(startIndex));
                            initialLoot.remove(startIndex);
                        }
                        System.out.println(stealLoops.toString().replaceAll("[\\[\\]]", ""));
                    }
                    break;
            }
            command = scanner.nextLine().split("\\s+");
        }
        if (initialLoot.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double sum = initialLoot.stream().mapToInt(String::length).sum();
            System.out.printf("Average treasure gain: %.2f pirate credits.", sum / initialLoot.size());
        }
    }
}