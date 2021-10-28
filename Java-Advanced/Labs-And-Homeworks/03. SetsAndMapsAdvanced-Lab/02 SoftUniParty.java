import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> guestsVIP = new TreeSet<>();
        TreeSet<String> guestsRegular = new TreeSet<>();
        String input = scanner.nextLine();
        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                guestsVIP.add(input);
            } else {
                guestsRegular.add(input);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("END")) {
            if (Character.isDigit(input.charAt(0))) {
                guestsVIP.remove(input);
            } else {
                guestsRegular.remove(input);
            }
            input = scanner.nextLine();
        }
        System.out.println(guestsVIP.size() + guestsRegular.size());
        guestsVIP.forEach(System.out::println);
        guestsRegular.forEach(System.out::println);
    }
}