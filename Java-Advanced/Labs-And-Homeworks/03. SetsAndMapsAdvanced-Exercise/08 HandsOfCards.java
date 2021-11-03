import java.util.*;

public class HandsOfCards_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> playerCards = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String[] player = input.split(": ");
            String personName = player[0];
            String[] cards = player[1].split(", ");
            playerCards.putIfAbsent(personName, new LinkedHashSet<>());
            for (String card : cards) {
                playerCards.get(personName).add(card);
            }
            input = scanner.nextLine();
        }
        playerCards.forEach((k, v) -> {
            int points = getPoints(v);
            System.out.println(k + ": " + points);
        });
    }

    private static int getPoints(Set<String> cards) {
        Map<Character, Integer> legend = getLegend();
        int points = 0;
        for (String card : cards) {
            int power;
            if (card.length() > 2) {
                power = 10;
            } else {
                power = legend.get(card.charAt(0));
            }
            int value = legend.get(card.charAt(card.length() - 1));
            points += power * value;
        }
        return points;
    }

    private static Map<Character, Integer> getLegend() {
        Map<Character, Integer> legend = new LinkedHashMap<>();
        legend.put('2', 2);
        legend.put('3', 3);
        legend.put('4', 4);
        legend.put('5', 5);
        legend.put('6', 6);
        legend.put('7', 7);
        legend.put('8', 8);
        legend.put('9', 9);
        legend.put('J', 11);
        legend.put('Q', 12);
        legend.put('K', 13);
        legend.put('A', 14);
        legend.put('S', 4);
        legend.put('H', 3);
        legend.put('D', 2);
        legend.put('C', 1);
        return legend;
    }
}