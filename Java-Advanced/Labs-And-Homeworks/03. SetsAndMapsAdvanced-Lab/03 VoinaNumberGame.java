import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class VoinaNumberGame_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> firstPlayer = fillSet(scanner);
        LinkedHashSet<Integer> secondPlayer = fillSet(scanner);
        int round = 1;
        while (round < 50) {
//            int cardFirstPlayer = getFirstCard(firstPlayer);
//            int cardSecondPlayer = getFirstCard(secondPlayer);
            int cardFirstPlayer = firstPlayer.iterator().next();
            int cardSecondPlayer = secondPlayer.iterator().next();
            removedCard(firstPlayer, cardFirstPlayer);
            removedCard(secondPlayer, cardSecondPlayer);

            if (cardFirstPlayer > cardSecondPlayer) {
                firstPlayer.add(cardFirstPlayer);
                firstPlayer.add(cardSecondPlayer);
            } else if (cardFirstPlayer < cardSecondPlayer) {
                secondPlayer.add(cardFirstPlayer);
                secondPlayer.add(cardSecondPlayer);
            }
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }

            round++;
        }

        if (secondPlayer.isEmpty() || firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (firstPlayer.isEmpty() || firstPlayer.size() < secondPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static LinkedHashSet<Integer> fillSet(Scanner scanner) {
        LinkedHashSet<Integer> player = new LinkedHashSet<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(player::add);
        return player;
    }

    private static int getFirstCard(LinkedHashSet<Integer> player) {
        return player.stream().findFirst().orElse(0);
    }

    private static void removedCard(LinkedHashSet<Integer> player, int card) {
        player.remove(card);
    }
}