import java.util.Scanner;

public class PrintPartOfTheASCIITable_5 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int firstIndex = Integer.parseInt(scanner.nextLine());
         int lastIndex = Integer.parseInt(scanner.nextLine());
        for (int i = firstIndex; i <= lastIndex ; i++) {
            System.out.print(String.format("%c ", i));
        }
    }
}
