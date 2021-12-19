package CardsWithPower_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();

        Card card = new Card(CardRanks.valueOf(cardRank), CardSuits.valueOf(cardSuit));
        System.out.printf("Card name: %s of %s; Card power: %d", card.cardRanks, card.cardSuit, card.power());
    }
}