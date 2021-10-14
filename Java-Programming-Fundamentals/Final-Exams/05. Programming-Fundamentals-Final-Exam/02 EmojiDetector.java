import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_2_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern patternD = Pattern.compile("[\\d]");
        Matcher matcherDigits = patternD.matcher(text);
        Pattern pattern = Pattern.compile("(?<delimiter>[:]{2}|[\\*]{2})(?<emoji>[A-Z][a-z]{2,})\\1");
        Matcher matcher = pattern.matcher(text);
        List<String> emojis = new ArrayList<>();
        long coolThresholdSum = 1;
        int countOfAllEmojis = 0;
        while (matcherDigits.find()) {
            int digit = Integer.parseInt(matcherDigits.group());
            coolThresholdSum *= digit;
        }
        while (matcher.find()) {
            countOfAllEmojis++;
            String emoji = matcher.group("emoji");
            int sum = 0;
            for (Character letter : emoji.toCharArray()) {
                sum += letter;
            }
            if (sum >= coolThresholdSum) {
                emojis.add(matcher.group());
            }
        }
        System.out.printf("Cool threshold: %d%n", coolThresholdSum);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", countOfAllEmojis);
        emojis.forEach(System.out::println);
    }
}