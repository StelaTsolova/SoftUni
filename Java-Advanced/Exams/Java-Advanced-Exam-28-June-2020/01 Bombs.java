import java.util.*;

public class Bombs_1_28June2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> bombEffects = fillQueue(scanner);
        ArrayDeque<Integer> bombCasings = fillStack(scanner);

        Map<String, Integer> bombs = new LinkedHashMap<>();
        bombs.put("Cherry Bombs", 0);
        bombs.put("Datura Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);

        boolean pouchIsFulfill = false;
        while (bombEffects.size() > 0 && bombCasings.size() > 0) {
            int bombEffect = bombEffects.poll();
            int bombCasing = bombCasings.pop();
            int sum = bombEffect + bombCasing;

            while (sum != 40 && sum != 60 && sum != 120) {
                sum -= 5;
            }

            if (sum == 40) {
                bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
            } else if (sum == 60) {
                bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
            } else {
                bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
            }

            pouchIsFulfill = checkPouch(bombs);
            if (pouchIsFulfill) {
                break;
            }
        }
        printResult(bombs, pouchIsFulfill, bombEffects, bombCasings);
    }

    private static boolean checkPouch(Map<String, Integer> bombs) {
        for (Map.Entry<String, Integer> bomb : bombs.entrySet()) {
            if (bomb.getValue() < 3) {
                return false;
            }
        }
        return true;
    }

    private static ArrayDeque<Integer> fillQueue(Scanner scanner) {
        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
        int[] sequence = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(sequence).forEach(bombEffects::offer);
        return bombEffects;
    }

    private static ArrayDeque<Integer> fillStack(Scanner scanner) {
        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();
        int[] sequence = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(sequence).forEach(bombCasings::push);
        return bombCasings;
    }

    private static void printResult(Map<String, Integer> bombs, boolean pouchIsFulfill, ArrayDeque<Integer> bombEffects, ArrayDeque<Integer> bombCasings) {
        printInfoForPouch(bombs, pouchIsFulfill);
        printInfoForBombEffects(bombEffects);
        printInfoForBombCasings(bombCasings);
        printInfoForBombs(bombs);
    }

    private static void printInfoForPouch(Map<String, Integer> bombs, boolean pouchIsFulfill) {
        if (pouchIsFulfill) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
    }

    private static void printInfoForBombEffects(ArrayDeque<Integer> bombEffects) {
        System.out.print("Bomb Effects: ");
        if (bombEffects.isEmpty()) {
            System.out.println("empty");
        } else {
            printBomb(bombEffects);
        }
    }

    private static void printInfoForBombCasings(ArrayDeque<Integer> bombCasings) {
        System.out.print("Bomb Casings: ");
        if (bombCasings.isEmpty()) {
            System.out.println("empty");
        } else {
            printBomb(bombCasings);
        }
    }

    private static void printBomb(ArrayDeque<Integer> bombs) {
        int counter = bombs.size();
        for (int bomb : bombs) {
            System.out.print(bomb);
            if (counter-- > 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private static void printInfoForBombs(Map<String, Integer> bombs) {
        bombs.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}