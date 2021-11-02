import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Set<String> usernames = new LinkedHashSet<>();
        while (lines-- > 0) {
            usernames.add(scanner.nextLine());
        }
        usernames.forEach(System.out::println);
    }
}