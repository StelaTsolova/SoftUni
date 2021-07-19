import java.util.Scanner;

public class Orders_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double price = 0.0;
        if (product.equals("coffee")) {
            price = 1.50;
            printTotalPrice(quantity, price);
        } else if (product.equals("water")) {
            price = 1.00;
            printTotalPrice(quantity, price);
        } else if (product.equals("coke")) {
            price = 1.40;
            printTotalPrice(quantity, price);
        } else if (product.equals("snacks")) {
            price = 2.00;
            printTotalPrice(quantity, price);
        }
    }

    private static void printTotalPrice(int quantity, double price) {
        System.out.printf("%.2f", quantity * price);

    }
}