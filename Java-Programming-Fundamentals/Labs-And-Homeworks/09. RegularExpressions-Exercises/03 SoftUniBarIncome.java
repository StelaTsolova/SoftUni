import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double income = 0;
        String regex = "%(?<customer>[A-Z][a-z]+)%[^\\|\\$\\%\\.]*<(?<product>[\\w]+)>([^\\|\\$\\%\\.]*)\\|(?<count>\\d+)\\|([^\\|\\$\\%\\.\\d]*)(?<price>\\d+(\\.\\d+)?)\\$";
        Pattern pattern = Pattern.compile(regex);
        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String customerName = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double totalPrice = count * price;
                income += totalPrice;
                System.out.printf("%s: %s - %.2f%n", customerName, product, totalPrice);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", income);
    }
}