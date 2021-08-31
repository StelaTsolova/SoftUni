import java.util.*;

public class ForceBook_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> forceUsers = new TreeMap<>();
        while (!input.equals("Lumpawaroo")) {
            boolean haveUser = false;
            if (input.contains("->")) {
                String[] array = input.split(" -> ");
                String user = array[0];
                String side = array[1];
                forceUsers.values().forEach(v -> v.removeIf(u -> u.equals(user)));
                forceUsers.putIfAbsent(side, new ArrayList<>());
                forceUsers.get(side).add(user);
                System.out.printf("%s joins the %s side!%n", user, side);
            } else {
                String[] array = input.split(" \\| ");
                String side = array[0];
                String user = array[1];
                forceUsers.putIfAbsent(side, new ArrayList<>());
                haveUser = forceUsers.values().stream().anyMatch(list -> list.contains(user));
                if (!haveUser) {
                    forceUsers.get(side).add(user);
                }
            }
            input = scanner.nextLine();
        }
        forceUsers.entrySet().stream().sorted((a1, a2) -> Integer.compare(a2.getValue().size(), a1.getValue().size()))
                .forEach(e -> {
                    if (e.getValue().isEmpty()) {
                        forceUsers.remove(e.getKey());
                    } else {

                        System.out.println("Side: " + e.getKey() + ", Members: " + e.getValue().size());
                    }
                    e.getValue().stream().sorted(String::compareTo).forEach(user -> System.out.println("! " + user));
                });
    }
}