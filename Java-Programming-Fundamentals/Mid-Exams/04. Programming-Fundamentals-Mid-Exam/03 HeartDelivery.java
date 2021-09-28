import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery_3_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> neighborhood = Arrays.stream(scanner.nextLine().split("@")).map(Integer::parseInt).collect(Collectors.toList());
        String[] command = scanner.nextLine().split("\\s+");
        int currentPosition = 0;
        boolean isZero = false;
        while (!command[0].equals("Love!")) {
            int length = Integer.parseInt(command[1]);
            currentPosition += length;
            if (currentPosition >= neighborhood.size()) {
                currentPosition = 0;
                if (neighborhood.get(0) != 0) {
                    neighborhood.set(0, neighborhood.get(0) - 2);
                } else {
                    isZero = true;
                    System.out.printf("Place %d already had Valentine's day.%n", currentPosition);
                }
            } else {
                if (neighborhood.get(currentPosition) != 0) {
                    neighborhood.set(currentPosition, neighborhood.get(currentPosition) - 2);
                } else {
                    isZero = true;
                    System.out.printf("Place %d already had Valentine's day.%n", currentPosition);
                }
            }
            if (!isZero && neighborhood.get(currentPosition) == 0){
                System.out.printf("Place %d has Valentine's day.%n", currentPosition);
            }
            isZero = false;
            command = scanner.nextLine().split("\\s+");
        }
        System.out.printf("Cupid's last position was %d.%n", currentPosition);
        int counter = (int) neighborhood.stream().filter(e -> e != 0).count();
        if (counter == 0){
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", counter);
        }
    }
}