import java.util.Scanner;

public class Elevator_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());
        double result = Math.ceil(people * 1.0 / capacity);
        System.out.println(String.format("%.0f", result));
    }
}