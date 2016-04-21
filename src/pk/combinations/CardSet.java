package pk.combinations;

import pk.model.Card;

import java.util.List;


public abstract class CardSet<T> implements Comparable<T> {

    protected List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        String s = "";
        for (Card card : cards) {
            s+=card.toString() + " ";
        }
        return s;
    }

    public int getWeight() {
        int w = 0;
        for (Card card : cards) {
            w+=card.hashCode();
        }
    }
}
