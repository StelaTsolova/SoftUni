import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new LinkedHashMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        boolean isObtained = false;
        while (!isObtained) {
            String[] input = scanner.nextLine().split(" ");
            for (int i = 1; i <= input.length; i += 2) {
                String material = input[i].toLowerCase();
                int quantity = Integer.parseInt(input[i - 1]);
                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    if ((keyMaterials.get(material) >= 250)) {
                        isObtained = true;
                        switch (material) {
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                break;
                        }
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        break;
                    }
                } else {
                    junkMaterials.putIfAbsent(material, 0);
                    junkMaterials.put(material, junkMaterials.get(material) + quantity);
                }
            }
        }
        keyMaterials.entrySet().stream().sorted((k, v) -> {
            int result = v.getValue().compareTo(k.getValue());
            if (result == 0) {
                result = k.getKey().compareTo(v.getKey());
            }
            return result;
        }).forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        junkMaterials.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}