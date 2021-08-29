import java.util.*;

public class OddOccurrences_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String word : words) {
            word = word.toLowerCase();

            if (counts.get(word) != null) {
                counts.put(word, counts.get(word) + 1);
            } else {
                counts.put(word, 1);
            }
        }
        List<String> output = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                output.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", output));
    }
}