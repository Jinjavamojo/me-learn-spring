package pk;


public class Hand {

    private int number;
    private Card firstCard;
    private Card secondCard;
    private CardSet cardSet;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public CardSet getCardSet() {
        return cardSet;
    }

    public void setCardSet(CardSet cardSet) {
        this.cardSet = cardSet;
    }

    public Card getFirstCard() {
        return firstCard;
    }

    public void setFirstCard(Card firstCard) {
        this.firstCard = firstCard;
    }

    public Card getSecondCard() {
        return secondCard;
    }

    public void setSecondCard(Card secondCard) {
        this.secondCard = secondCard;
    }
}
