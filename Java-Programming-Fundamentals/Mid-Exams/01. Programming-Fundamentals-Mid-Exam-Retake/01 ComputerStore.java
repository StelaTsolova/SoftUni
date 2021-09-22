import java.util.Scanner;

public class ComputerStore_1_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double priceWithoutTax = 0.0;
        while (!input.equals("special") && !input.equals("regular")) {
            double price = Double.parseDouble(input);
            if (price >= 0) {
                priceWithoutTax += price;
            } else {
                System.out.println("Invalid price!");
            }
            input = scanner.nextLine();
        }
        if (priceWithoutTax == 0.0) {
            System.out.println("Invalid order!");
        } else {
            double taxes = priceWithoutTax * 0.2;
            double totalPrice = priceWithoutTax + taxes;
            if (input.equals("special")) {
                totalPrice -= totalPrice * 0.1;
            }
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%nTaxes: %.2f$%n", priceWithoutTax, taxes);
            System.out.printf("-----------%nTotal price: %.2f$", totalPrice);
        }
    }
}