import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> invitations = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> removedGuests = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("Print")) {
            String[] command = input.split(";");
            Predicate<String> predicate = getPredicate(command[1], command[2]);
            if (command[0].equals("Add filter")) {
                removedGuests.addAll(removesInvited(predicate, invitations));
                invitations.removeIf(predicate);
            } else if (command[0].equals("Remove filter")) {
                invitations.addAll(removesInvited(predicate, removedGuests));
                removedGuests.removeIf(predicate);
            } else if (command[0].equals("Print")) {
                invitations.stream().filter(predicate).forEach(e -> System.out.print(e + " "));
            }

            input = scanner.nextLine();

        }
        System.out.println(invitations.toString().replaceAll("[\\[\\],]", ""));
    }

    private static List<String> removesInvited(Predicate<String> predicate, List<String> invitations) {
        return invitations.stream().filter(predicate).collect(Collectors.toList());
    }

    private static Predicate<String> getPredicate(String type, String parameter) {
        if (type.equals("Starts with")) {
            return e -> e.startsWith(parameter);
        } else if (type.equals("Ends with")) {
            return e -> e.endsWith(parameter);
        } else if (type.equals("Length")) {
            int limit = Integer.parseInt(parameter);
            return e -> e.length() == limit;
        } else {
            return e -> e.contains(parameter);
        }
    }
}