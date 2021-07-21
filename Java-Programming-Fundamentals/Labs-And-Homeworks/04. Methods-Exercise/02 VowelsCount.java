import java.util.Locale;
import java.util.Scanner;

public class VowelsCount_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine().toLowerCase(Locale.ROOT);
        printCountVoles(string);
    }

    private static void printCountVoles(String word) {
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            switch (letter) {
                case 'a':
                case 'e':
                case 'o':
                case 'i':
                case 'u':
                    counter++;
                    break;
            }
        }
        System.out.println(counter);
    }
}