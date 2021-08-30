import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders_4 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Map<String, Double> price = new LinkedHashMap<>();
        Map<String, Integer> quantity = new LinkedHashMap<>();
        while (!input[0].equals("buy")) {
            String nameProduct = input[0];
            double currentPrice = Double.parseDouble(input[1]);
            int currentQuantity = Integer.parseInt(input[2]);
            if (!price.containsKey(nameProduct)) {
                price.put(nameProduct, currentPrice);
                quantity.put(nameProduct, currentQuantity);
            } else {
                price.put(nameProduct, currentPrice);
                quantity.put(nameProduct, quantity.get(nameProduct) + currentQuantity);
            }
            input = scanner.nextLine().split("\\s+");
        }
        for (Map.Entry<String, Double> entry : price.entrySet()) {
            double totalPrice = entry.getValue() * quantity.get(entry.getKey());
            System.out.printf("%s -> %.2f%n", entry.getKey(), totalPrice);

        }
    }
}