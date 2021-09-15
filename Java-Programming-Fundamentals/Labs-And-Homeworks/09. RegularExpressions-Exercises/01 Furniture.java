import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>\\d+(\\.\\d+)?)!(?<quantity>\\d+)\\b";
        Pattern pattern = Pattern.compile(regex);
        List<String> furniture = new ArrayList<>();
        double spendMoney = 0;
        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()){
                String typeFurniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                furniture.add(typeFurniture);
                spendMoney += price * quantity;
            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        furniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", spendMoney);
    }
}