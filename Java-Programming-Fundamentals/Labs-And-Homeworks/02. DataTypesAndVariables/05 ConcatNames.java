import java.util.Scanner;

public class ConcatNames_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();
        String delimiter = scanner.nextLine();
        System.out.println(String.format("%s%s%s", firstName, delimiter, secondName));
    }
}
