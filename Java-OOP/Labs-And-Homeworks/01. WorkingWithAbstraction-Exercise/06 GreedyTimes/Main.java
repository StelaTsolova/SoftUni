package GreedyTimes_6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        Bag bag = new Bag(bagCapacity);

        String[] safe = scanner.nextLine().split("\\s+");

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long amount = Long.parseLong(safe[i + 1]);

            if (bag.sum() + amount > bagCapacity) {
                continue;
            }

            if (name.equalsIgnoreCase("gold")) {
                bag.addGold(amount);
            } else if (name.length() == 3) {
                if (bag.sumCash() + amount <= bag.sumGems())
                    bag.addCash(name, amount);
            } else if (name.toLowerCase().endsWith("gem")) {
                if (bag.sumGems() + amount <= bag.sumGolds()) {
                    bag.addGem(name, amount);
                }
            }
        }
        System.out.println(bag.print());
    }
}