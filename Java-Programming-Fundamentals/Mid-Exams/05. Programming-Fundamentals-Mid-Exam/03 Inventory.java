import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Inventory_3_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String[] command = scanner.nextLine().split(" - ");
        while (!command[0].equals("Craft!")) {
            switch (command[0]) {
                case "Collect":
                    if (!items.contains(command[1])){
                        items.add(command[1]);
                    }
                    break;
                case "Drop":
                    items.remove(command[1]);
                    break;
                case "Combine Items":
                    String[] itemsCombine = command[1].split(":");
                    String oldItem = itemsCombine[0];
                    String newItem = itemsCombine[1];
                    if (items.contains(oldItem)){
                        int index = items.indexOf(oldItem);
                        if (index + 1 < items.size()){
                            items.add(index + 1, newItem);
                        } else {
                            items.add(newItem);
                        }
                    }
                    break;
                case "Renew":
                    if(items.contains(command[1])) {
                        items.remove(command[1]);
                        items.add(command[1]);
                    }
                    break;
            }
            command = scanner.nextLine().split(" - ");
        }
        System.out.println(items.toString().replaceAll("[\\[\\]]", ""));
    }
}