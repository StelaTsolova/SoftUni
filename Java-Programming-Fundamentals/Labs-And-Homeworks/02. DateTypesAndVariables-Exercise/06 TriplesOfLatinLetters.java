import java.util.Scanner;

public class TriplesOfLatinLetters_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 97; i < 97 + n; i++) {
            for (int j = 97; j < 97 + n; j++) {
                for (int k = 97; k < 97 + n; k++) {
                    System.out.println(String.format("%c%c%c", i, j, k));
                }
            }
        }
    }
}
