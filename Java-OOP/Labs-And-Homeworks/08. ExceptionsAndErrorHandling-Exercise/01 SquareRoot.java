import java.util.Scanner;

public class SquareRoot_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            int number = Integer.parseInt(input);
            System.out.println(Math.sqrt(number));
        } catch (NumberFormatException ex) {
            System.out.println("Invalid number");
        } finally {
            System.out.println("Good bye");
        }
    }
}
