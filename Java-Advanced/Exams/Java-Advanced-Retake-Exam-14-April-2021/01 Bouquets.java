import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets_1_14April2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> tulips = fillStack(scanner);
        ArrayDeque<Integer> daffodils = fillQueue(scanner);

        int bouquet = 0;
        int sumForLater = 0;
        while (tulips.size() > 0 && daffodils.size() > 0) {
            int tulip = tulips.poll();
            int daffodil = daffodils.pop();
            int sum = tulip + daffodil;

            while (sum > 15) {
                sum -= 2;
            }
            if (sum == 15) {
                bouquet++;
            } else {
                sumForLater += sum;
            }
        }

        bouquet += sumForLater / 15;

        if (bouquet >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquet);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquet);
        }

    }

    private static ArrayDeque<Integer> fillQueue(Scanner scanner) {
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        int[] sequence = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(sequence).forEach(daffodils::offer);
        return daffodils;
    }

    private static ArrayDeque<Integer> fillStack(Scanner scanner) {
        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        int[] sequence = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(sequence).forEach(tulips::push);
        return tulips;
    }
}