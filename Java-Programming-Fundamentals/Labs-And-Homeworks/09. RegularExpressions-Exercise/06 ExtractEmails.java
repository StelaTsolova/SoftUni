import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String emailRegex = "(?<user>[A-Za-z0-9]+([\\.\\-\\_][A-Za-z-0-9]+)?)@(?<host>[A-Za-z]+[\\-]*[A-Za-z]*\\.[A-Za-z]+[\\-]*[A-Za-z]*(\\.[A-Za-z]+[\\-]*[A-Za-z]*)*)";
        Pattern emailPattern = Pattern.compile(emailRegex);
        String text = scanner.nextLine();
        Matcher emailMatcher = emailPattern.matcher(text);
        while (emailMatcher.find()) {
            System.out.println(emailMatcher.group());
        }
    }
}