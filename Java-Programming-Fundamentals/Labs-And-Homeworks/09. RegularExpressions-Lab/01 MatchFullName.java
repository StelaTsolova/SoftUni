import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName_1 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";
         String names = scanner.nextLine();
        Pattern patter = Pattern.compile(regex);
        Matcher matcher = patter.matcher(names);
        while (matcher.find()){
            System.out.print(matcher.group() + " ");
        }
    }
}