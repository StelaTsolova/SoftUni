import java.util.*;

public class LogsAggregator_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> durations = new TreeMap<>();
        Map<String, Set<String>> IPs = new LinkedHashMap<>();
        while (lines-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String IP = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);
            durations.putIfAbsent(user, 0);
            durations.put(user, durations.get(user) + duration);
            IPs.putIfAbsent(user, new TreeSet<>());
            IPs.get(user).add(IP);
        }
        durations.forEach((k, v) -> {
            System.out.printf("%s: %d ", k, v);
            System.out.print("[");
            System.out.print(String.join(", ", IPs.get(k)));
            System.out.println("]");
        });
    }
}