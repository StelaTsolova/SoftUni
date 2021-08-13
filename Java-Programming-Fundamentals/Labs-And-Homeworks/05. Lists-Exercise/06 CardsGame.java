import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        while (!firstDeck.isEmpty() && !secondDeck.isEmpty()) {
            boolean firstIsWinner = checkBiggerCard(firstDeck, secondDeck);
            if (firstIsWinner){
                firstDeck.add(secondDeck.get(0));
                firstDeck.add(firstDeck.get(0));
                firstDeck.remove(0);
                secondDeck.remove(0);
            } else {
                boolean cardsAreEqual = checkEqualCard(firstDeck, secondDeck);
                if (cardsAreEqual){
                    firstDeck.remove(0);
                    secondDeck.remove(0);
                } else {
                    secondDeck.add(firstDeck.get(0));
                    secondDeck.add(secondDeck.get(0));
                    secondDeck.remove(0);
                    firstDeck.remove(0);
                }
            }
        }
        String winner = getName (firstDeck, secondDeck);
        int sum = getSum(firstDeck, secondDeck);
        System.out.printf("%s player wins! Sum: %d",winner, sum);

    }

    private static boolean checkBiggerCard(List<Integer> firstDeck, List<Integer> secondDeck) {
        return firstDeck.get(0) > secondDeck.get(0);

    }

    private static boolean checkEqualCard(List<Integer> firstDeck, List<Integer> secondDeck) {
        return firstDeck.get(0).equals(secondDeck.get(0));
    }

    private static String getName(List<Integer> firstDeck, List<Integer> secondDeck) {
        String winner = "";
        int sum = 0;
        if (firstDeck.isEmpty()){
            winner = "Second";
        } else {
            winner = "First";
        }
        return winner;
    }

    private static int getSum(List<Integer> firstDeck, List<Integer> secondDeck) {
        int sum = 0;
        if (firstDeck.isEmpty()){
            for (int number:secondDeck){
                sum += number;
            }
        } else {
            for (int number:firstDeck){
                sum += number;
            }
        }
        return sum;
    }
}