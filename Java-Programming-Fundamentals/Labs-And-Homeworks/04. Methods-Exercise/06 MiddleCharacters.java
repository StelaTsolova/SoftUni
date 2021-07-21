import java.util.Scanner;

public class MiddleCharacters_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        printMiddleCharacter(string);
    }

    private static void printMiddleCharacter(String string) {
            int index = string.length() / 2;
        if (string.length() % 2 == 0) {
            System.out.printf("%c%c", string.charAt(index - 1), string.charAt(index));
        } else {
            System.out.println(string.charAt(index));
        }
    }
}