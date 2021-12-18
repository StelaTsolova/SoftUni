package HotelReservation_4;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String[] information = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(information[0]);
        int days = Integer.parseInt(information[1]);
        Season season = Season.valueOf(information[2].toUpperCase());
        Discount discount = Discount.parseDiscountType(information[3]);

        PriceCalculator calculator = new PriceCalculator(pricePerDay, days, season, discount);
        System.out.printf("%.2f",calculator.calculatePrice());
    }
}