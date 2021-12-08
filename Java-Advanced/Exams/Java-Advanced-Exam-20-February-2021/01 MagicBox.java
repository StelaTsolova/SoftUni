import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox_1_20February2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> firstMagicBox = fillQueue(scanner);
        ArrayDeque<Integer> secondMagicBox = fillStack(scanner);

        int sumOfClaimedItems = 0;
        while (firstMagicBox.size() > 0 && secondMagicBox.size() > 0) {
            int itemFirstMagicBox = firstMagicBox.peek();
            int itemSecondMagicBox = secondMagicBox.pop();
            int sum = itemFirstMagicBox + itemSecondMagicBox;

            if (sum % 2 == 0) {
                firstMagicBox.poll();
                sumOfClaimedItems += sum;
            } else {
                firstMagicBox.offer(itemSecondMagicBox);
            }
        }

        if (firstMagicBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        if (sumOfClaimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + sumOfClaimedItems);
        } else {
            System.out.println("Poor prey... Value: " + sumOfClaimedItems);
        }
    }

    private static ArrayDeque<Integer> fillQueue(Scanner scanner) {
        ArrayDeque<Integer> firstMagicBox = new ArrayDeque<>();
        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(sequence).forEach(firstMagicBox::offer);
        return firstMagicBox;
    }

    private static ArrayDeque<Integer> fillStack(Scanner scanner) {
        ArrayDeque<Integer> secondMagicBox = new ArrayDeque<>();
        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(sequence).forEach(secondMagicBox::push);
        return secondMagicBox;
    }
}