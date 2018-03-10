package enumsAndAnnotations;

public class Card implements Comparable<Card>{

    private CardSuit cardSuit;

    private CardRanks cardRank;

    private int cardPower;

    public Card(CardSuit cardSuit, CardRanks cardRank) {
        this.setCardSuit(cardSuit);
        this.setCardRank(cardRank);
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    private void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public CardRanks getCardRank() {
        return cardRank;
    }

    private void setCardRank(CardRanks cardRank) {
        this.cardRank = cardRank;
    }

    public int getCardPower() {
        this.setCardPower();
        return cardPower;
    }

    private void setCardPower() {
        this.cardPower = this.cardRank.getPower() + this.cardSuit.getPower();
    }

    @Override
    public String toString() {
        return String.format("%s of %s.", this.getCardRank(), this.getCardSuit());
    }

    @Override
    public int compareTo(Card cardToCompare) {
        return this.getCardPower() - cardToCompare.getCardPower();
    }
}
