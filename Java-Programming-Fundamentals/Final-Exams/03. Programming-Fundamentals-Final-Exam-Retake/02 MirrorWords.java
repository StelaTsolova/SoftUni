import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_2_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<String, String> mirrors = new LinkedHashMap<>();
        int words = 0;
        Pattern pattern = Pattern.compile("([@|#])(?<word>[A-Za-z]{3,})\\1\\1(?<mirror>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            StringBuilder reversWord = new StringBuilder(matcher.group("word"));
            reversWord.reverse();
            if (matcher.group("mirror").equals(reversWord.toString())) {
                mirrors.put(matcher.group("word"), matcher.group("mirror"));
            }
            words++;
        }
        if (words == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", words);
        }
        if (mirrors.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            int[] counter = {1};
            mirrors.forEach((k, v) -> {
                System.out.printf("%s <=> %s", k, v);
                if (counter[0] < mirrors.size()) {
                    System.out.print(", ");
                }
                counter[0]++;
            });

        }
    }
}