import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new TreeMap<>();
        Map<String, Integer> junk = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        String material = "";
        boolean end = false;
        while (true) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int index = 1; index < input.length; index += 2) {
                String element = input[index].toLowerCase();
                int quantity = Integer.parseInt(input[index - 1]);
                if (checkElementIsKeys(element)) {
                    keyMaterials.put(element, keyMaterials.get(element) + quantity);
                    if (keyMaterials.get(element) >= 250) {
                        material = element;
                        keyMaterials.put(element, keyMaterials.get(element) - 250);
                        end = true;
                        break;
                    }
                } else {
                    junk.putIfAbsent(element, 0);
                    junk.put(element, junk.get(element) + quantity);
                }
            }
            if (end) {
                break;
            }
        }
        String legendaryItem = getLegendaryItem(material);
        System.out.println(legendaryItem + " obtained!");
        keyMaterials.entrySet().stream().sorted((q1, q2) -> q2.getValue().compareTo(q1.getValue())).forEach(e -> {
            System.out.println(e.getKey() + ": " + e.getValue());
        });
        junk.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public static boolean checkElementIsKeys(String element) {
        return element.equals("shards") || element.equals("fragments") || element.equals("motes");
    }

    private static String getLegendaryItem(String material) {
        if (material.equals("shards")) {
            return "Shadowmourne";
        }
        if (material.equals("fragments")) {
            return "Valanyr";
        }
        if (material.equals("motes")) {
            return "Dragonwrath";
        }
        return "mistake";
    }
}