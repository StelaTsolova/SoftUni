import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_2_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("([#|\\\\|])(?<name>[A-Za-z ]+)\\1(?<expirationDate>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]{1,5})\\1");
        Matcher matcher = pattern.matcher(text);
        int totalCalories = 0;
        List<String> foods = new ArrayList<>();
        while (matcher.find()) {
            totalCalories += Integer.parseInt(matcher.group("calories"));
            foods.add(String.format("Item: %s, Best before: %s, Nutrition: %s%n", matcher.group("name"), matcher.group("expirationDate"), matcher.group("calories")));
        }
        int amountDays = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", amountDays);
        foods.forEach(System.out::print);
    }
}