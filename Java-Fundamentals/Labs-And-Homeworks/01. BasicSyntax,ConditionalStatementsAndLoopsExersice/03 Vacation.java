import java.util.Scanner;

public class Vacation_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPeople = Integer.parseInt(scanner.nextLine());
        String typePeople = scanner.nextLine();
        String typeDay = scanner.nextLine();
        double price = 0.0;

        if (typeDay.equals("Friday")) {
            if (typePeople.equals("Students")) {
                price = 8.45;
            } else if (typePeople.equals("Business")) {
                price = 10.90;
            } else if (typePeople.equals("Regular")) {
                price = 15;
            }
        } else if (typeDay.equals("Saturday")) {
            if (typePeople.equals("Students")) {
                price = 9.80;
            } else if (typePeople.equals("Business")) {
                price = 15.60;
            } else if (typePeople.equals("Regular")) {
                price = 20;
            }
        } else if (typeDay.equals("Sunday")) {
            if (typePeople.equals("Students")) {
                price = 10.46;
            } else if (typePeople.equals("Business")) {
                price = 16;
            } else if (typePeople.equals("Regular")) {
                price = 22.50;
            }
        }
        double totalPrice = numPeople * price;
        if (numPeople >= 30 && typePeople.equals("Students")) {
            totalPrice -= totalPrice * 0.15;
        } else if (numPeople >= 100 && typePeople.equals("Business")) {
            totalPrice -= 10 * price;
        } else if (numPeople >= 10 && numPeople <= 20 && typePeople.equals("Regular")){
            totalPrice -= totalPrice * 0.05;
        }
        System.out.println(String.format("Total price: %.2f", totalPrice));
    }
}