import java.util.Scanner;

public class ReversedChars_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);
        char thirdSymbol = scanner.nextLine().charAt(0);
        String output = String.format("%c %c %c", thirdSymbol, secondSymbol, firstSymbol);
        System.out.println(output);
    }
}