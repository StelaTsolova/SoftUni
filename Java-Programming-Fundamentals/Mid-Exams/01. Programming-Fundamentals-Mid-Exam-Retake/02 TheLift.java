import java.util.Arrays;
import java.util.Scanner;

public class TheLift_2_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tourist = Integer.parseInt(scanner.nextLine());
        int[] wagons = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < wagons.length; i++) {
            int wagon = wagons[i];
            if (tourist == 0) {
                break;
            }
            if (wagon < 4) {
                int separated = 4 - wagon;
                for (int j = 0; j < separated; j++) {
                    if (tourist == 0) {
                        break;
                    }
                    wagons[i] = ++wagon;
                    tourist--;
                }
            }
        }
        if (tourist == 0 && wagons[wagons.length - 1] != 4) {
            System.out.println("The lift has empty spots!");
        } else if (tourist > 0 && wagons[wagons.length - 1] == 4) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", tourist);
        }
        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}