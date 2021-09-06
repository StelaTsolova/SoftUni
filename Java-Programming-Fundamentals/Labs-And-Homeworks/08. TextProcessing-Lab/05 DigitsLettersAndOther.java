import java.util.Scanner;

public class DigitsLettersAndOther_5 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String input = scanner.nextLine();
         StringBuilder digits = new StringBuilder();
         StringBuilder letters = new StringBuilder();
         StringBuilder other = new StringBuilder();
         for (Character symbol:input.toCharArray()){
             if (Character.isDigit(symbol)){
                 digits.append(symbol);
             } else if (Character.isAlphabetic(symbol)){
                 letters.append(symbol);
             } else {
                 other.append(symbol);
             }
         }
        System.out.printf("%s%n%s%n%s%n", digits, letters, other);
    }
}