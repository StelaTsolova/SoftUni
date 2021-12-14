import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths_1_19August2020 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> lilies = fillStack(scanner);
        ArrayDeque<Integer> roses = fillQueue(scanner);

        int wreaths = 0;
        int sumForLater = 0;
        while (lilies.size() > 0 && roses.size() > 0) {
            int lili = lilies.poll();
            int rose = roses.pop();
            int sum = lili + rose;

            while (sum > 15) {
                sum -= 2;
            }
            if (sum == 15) {
                wreaths++;
            } else {
                sumForLater += sum;
            }
        }

        wreaths += sumForLater / 15;

        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }
    }

    private static ArrayDeque<Integer> fillQueue(Scanner scanner) {
        ArrayDeque<Integer> roses = new ArrayDeque<>();
        int[] sequence = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(sequence).forEach(roses::offer);
        return roses;
    }

    private static ArrayDeque<Integer> fillStack(Scanner scanner) {
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        int[] sequence = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(sequence).forEach(lilies::push);
        return lilies;
    }
}
