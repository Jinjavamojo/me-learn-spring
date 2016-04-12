package pk.combinations;

import pk.Card;

import java.util.List;

public class Pair {

    public final Card card1;
    public final Card card2;

    public Pair(Card card1, Card card2) {
        this.card1 = card1;
        this.card2 = card2;
    }

    public boolean contains(Card card) {
        return card1.equals(card) || card2.equals(card);
    }

    public Card getCard1() {
        return card1;
    }

    public Card getCard2() {
        return card2;
    }
}
