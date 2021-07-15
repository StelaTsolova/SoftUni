import java.util.Scanner;

public class RageExpenses_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countLostGames = Integer.parseInt(scanner.nextLine());
        double priceHeadset = Double.parseDouble(scanner.nextLine());
        double priceMouse = Double.parseDouble(scanner.nextLine());
        double priceKeyboard = Double.parseDouble(scanner.nextLine());
        double priceDisplay = Double.parseDouble(scanner.nextLine());

        int countHeadset = countLostGames / 2;
        int countMouse = countLostGames / 3;
        int countKeyboard = countLostGames / 6;
        int countDisplay = countKeyboard / 2;

        double total = priceHeadset * countHeadset + priceMouse * countMouse + priceKeyboard * countKeyboard + priceDisplay * countDisplay;
        System.out.println(String.format("Rage expenses: %.2f lv.", total));
    }
}