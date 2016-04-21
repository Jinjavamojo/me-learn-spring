package pk.combinations;

import pk.model.Card;

import java.util.ArrayList;

public class Pair extends CardSet<Pair> {

    public final Card card1;
    public final Card card2;
    private boolean haveEqualPair = false;

    public Pair(Card card1, Card card2) {
        cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
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

    public int getWeight() {
        return card1.getRank().getValue() + card2.getRank().getValue();
    }

    public boolean isHaveEqualPair() {
        return haveEqualPair;
    }

    public void setHaveEqualPair(boolean haveEqualPair) {
        this.haveEqualPair = haveEqualPair;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.card1.getRank().getValue() > o.getCard1().getRank().getValue())
            return 1;
        if (this.card1.getRank().getValue() < o.getCard1().getRank().getValue())
            return -1;
        return 0;
    }
}
