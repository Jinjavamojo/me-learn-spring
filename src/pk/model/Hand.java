package pk.model;


import pk.combinations.CardSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hand {

    private int number;
    private Card firstCard;
    private Card secondCard;
    private List<CardSet> cardSets;

    public Hand(int number) {
        this.number = number;
    }

    public void initializeCards(Card c1, Card c2) {
        firstCard = c1;
        secondCard = c2;
        cardSets = new ArrayList<>();
    }

    public Collection<Card> getCards() {
        try {
            List<Card> cards = new ArrayList<>();
            cards.add(firstCard.clone());
            cards.add(secondCard.clone());
            return cards;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
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
