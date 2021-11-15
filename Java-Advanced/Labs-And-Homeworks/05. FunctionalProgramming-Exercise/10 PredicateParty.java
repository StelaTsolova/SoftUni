import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String[] command = input.split("\\s+");
            if (command[0].equals("Double")) {
                addOneMore(getPredicate(command[1], command[2]), guests);
            } else if (command[0].equals("Remove")) {
                guests.removeIf(getPredicate(command[1], command[2]));
            }
            input = scanner.nextLine();
        }
        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            guests.sort(Comparator.naturalOrder());
            System.out.println(String.join(", ", guests) + " are going to the party!");
        }
    }

    private static void addOneMore(Predicate<String> predicate, List<String> guests) {
        List<String> doubleGuests = guests.stream().filter(predicate).collect(Collectors.toList());
        guests.addAll(doubleGuests);
    }

    public static Predicate<String> getPredicate(String command, String range) {
        if (command.equals("StartsWith")) {
            return e -> e.startsWith(range);
        } else if (command.equals("EndsWith")) {
            return e -> e.endsWith(range);
        } else {
            int limit = Integer.parseInt(range);
            return e -> e.length() == limit;
        }
    }
}