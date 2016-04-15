package pk.model;


import pk.combinations.CardSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hand {

    private int number;
    private Card firstCard;
    private Card secondCard;

    public Hand(int number) {
        this.number = number;
    }

    public Hand(int number, Card firstCard, Card secondCard) {
        this.number = number;
        this.firstCard = firstCard;
        this.secondCard = secondCard;
    }

    public void initializeCards(Card c1, Card c2) {
        firstCard = c1;
        secondCard = c2;
    }

    public Collection<Card> getCards() {
            List<Card> cards = new ArrayList<>();
            cards.add(firstCard.clone());
            cards.add(secondCard.clone());
            return cards;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
