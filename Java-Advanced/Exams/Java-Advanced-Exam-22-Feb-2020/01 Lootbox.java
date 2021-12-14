import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Lootbox_1_22Feb2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> firstLootBox = fillQueue(scanner);
        ArrayDeque<Integer> secondLootBox = fillStack(scanner);

        int sumOfClaimedItems = 0;
        while (firstLootBox.size() > 0 && secondLootBox.size() > 0) {
            int itemFirstLootBox = firstLootBox.peek();
            int itemSecondLootBox = secondLootBox.pop();
            int sum = itemFirstLootBox + itemSecondLootBox;

            if (sum % 2 == 0) {
                firstLootBox.poll();
                sumOfClaimedItems += sum;
            } else {
                firstLootBox.offer(itemSecondLootBox);
            }
        }

        if (firstLootBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (sumOfClaimedItems >= 100) {
            System.out.println("Your loot was epic! Value: " + sumOfClaimedItems);
        } else {
            System.out.println("Your loot was poor... Value: " + sumOfClaimedItems);
        }
    }

    private static ArrayDeque<Integer> fillQueue(Scanner scanner) {
        ArrayDeque<Integer> firstLootBox = new ArrayDeque<>();
        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(sequence).forEach(firstLootBox::offer);
        return firstLootBox;
    }

    private static ArrayDeque<Integer> fillStack(Scanner scanner) {
        ArrayDeque<Integer> secondLootBox = new ArrayDeque<>();
        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(sequence).forEach(secondLootBox::push);
        return secondLootBox;
    }
}