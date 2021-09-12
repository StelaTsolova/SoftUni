import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber_2 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String regex = "\\+359([ -])2\\1\\d{3}\\1\\d{4}\\b";
         String phoneNumbers = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher mather = pattern.matcher(phoneNumbers);
        List<String> validPhoneNumbers = new ArrayList<>();
        while (mather.find()){
            validPhoneNumbers.add(mather.group());
        }
        System.out.println(validPhoneNumbers.toString().replaceAll("[\\[\\]]", ""));
    }
}