import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Integer> collectResources = new LinkedHashMap<>();
        while (!command.equals("stop")) {
            String resource = command;
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!collectResources.containsKey(resource)) {
                collectResources.put(resource, quantity);
            } else {
                collectResources.put(resource, collectResources.get(resource) + quantity);
            }
            command = scanner.nextLine();
        }
        collectResources.forEach((k,v) -> System.out.println(k + " -> " + v));
    }
}