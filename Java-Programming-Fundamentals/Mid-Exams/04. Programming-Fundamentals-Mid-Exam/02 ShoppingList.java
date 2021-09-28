import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList_2_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> initialList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());
        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("Go")) {
            String item = command[1];
            switch (command[0]) {
                case "Urgent":
                    if (!initialList.contains(item)){
                        initialList.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    initialList.remove(item);
                    break;
                case "Correct":
                    String newItem = command[2];
                    if (initialList.contains(item)){
                        int indexItem = initialList.indexOf(item);
                        initialList.set(indexItem, newItem);
                    }
                    break;
                case "Rearrange":
                    if (initialList.contains(item)){
                        initialList.remove(item);
                        initialList.add(item);
                    }
                    break;
            }
            command = scanner.nextLine().split("\\s+");
        }
        System.out.println(initialList.toString().replaceAll("[\\[\\]]", ""));
    }
}