package CardsWithPower_3;

public class Card {
    CardRanks cardRanks;
    CardSuits cardSuit;

    public Card(CardRanks cardRanks, CardSuits cardSuit) {
        this.cardRanks = cardRanks;
        this.cardSuit = cardSuit;
    }

    public int power() {
        return cardRanks.getPower() + cardSuit.getPower();
    }
}
