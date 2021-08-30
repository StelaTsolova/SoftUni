import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString_1 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String text = scanner.nextLine();
        Map<Character, Integer> occurrences = new LinkedHashMap<>();
        for (int i = 0; i < text.length(); i++) {
            Character letter = text.charAt(i);
            if (letter == ' '){
                continue;
            }
            if (!occurrences.containsKey(letter)) {
                occurrences.put(letter, 1);
            } else {
                occurrences.put(letter, occurrences.get(letter) + 1);
            }
        }
        occurrences.forEach((k,v) -> System.out.println(k + " -> " + v));
    }
}