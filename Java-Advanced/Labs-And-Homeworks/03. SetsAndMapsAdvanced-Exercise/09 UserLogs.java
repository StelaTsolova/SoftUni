import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> information = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] display = input.split("\\s+");
            String IP = display[0].substring(3);
            String username = display[2].substring(5);
            information.putIfAbsent(username, new LinkedHashMap<>());
            information.get(username).putIfAbsent(IP, 0);
            information.get(username).put(IP, information.get(username).get(IP) + 1);
            input = scanner.nextLine();
        }
        information.forEach((k, v) -> {
            System.out.println(k + ":");
            int countIP = v.keySet().size();
            for (Map.Entry<String, Integer> e : v.entrySet()) {
                System.out.printf("%s => %d", e.getKey(), e.getValue());
                if (countIP-- > 1) {
                    System.out.print(", ");
                } else {
                    System.out.printf(".%n");
                }
            }
        });
    }
}