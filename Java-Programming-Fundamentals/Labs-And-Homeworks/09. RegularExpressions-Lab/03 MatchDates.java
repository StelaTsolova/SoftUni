import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates_3 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String regex = "\\b(?<day>\\d{2})([\\.\\-\\/])(?<month>[A-z][a-z]{2})\\2(?<year>\\d{4})\\b";
         String dates = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dates);
        while (matcher.find()){
            System.out.printf("Day: %s, Month: %s, Year: %s%n", matcher.group("day"), matcher.group("month"), matcher.group("year"));
        }
    }
}