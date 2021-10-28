import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> information = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String[] order = input.split(", ");
            String shop = order[0];
            String product = order[1];
            double price = Double.parseDouble(order[2]);
            information.putIfAbsent(shop, new LinkedHashMap<>());
            information.get(shop).put(product, price);

            input = scanner.nextLine();
        }
        information.forEach((k, e) ->{
            System.out.println(k + "->");
            e.forEach((k1, v) ->System.out.printf("Product: %s, Price: %.1f%n", k1, v));
        });
    }
}