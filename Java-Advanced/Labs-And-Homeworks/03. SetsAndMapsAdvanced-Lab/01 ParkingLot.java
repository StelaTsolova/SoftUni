import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> carNumbers = new LinkedHashSet<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] information = input.split(", ");
            String direction = information[0];
            String currentCarNumber = information[1];
            switch (direction) {
                case "IN":
                    carNumbers.add(currentCarNumber);
                    break;
                case "OUT":
                    carNumbers.remove(currentCarNumber);
                    break;
            }
            input = scanner.nextLine();
        }
        if (carNumbers.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            carNumbers.forEach(System.out::println);
        }
    }
}