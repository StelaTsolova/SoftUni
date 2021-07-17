import java.util.Scanner;

public class VendingMachine_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double money = 0.0;
        double price = 0.0;
        boolean isInvalid = false;
        while (!input.equals("Start")) {
            double coin = Double.parseDouble(input);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                money += coin;
            } else {
                System.out.println(String.format("Cannot accept %.2f", coin));
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("End")) {
            switch (input) {
                case "Nuts":
                    price = 2.0;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1.0;
                    break;
                default:
                    isInvalid = true;
                    System.out.println("Invalid product");
                    break;
            }
            if (!isInvalid) {
                if (money >= price) {
                    money -= price;
                    System.out.println(String.format("Purchased %s", input));
                } else {
                    System.out.println("Sorry, not enough money");
                }
            }
            isInvalid = false;
            input = scanner.nextLine();
        }
        System.out.println(String.format("Change: %.2f", money));
    }
}