package pk;

import com.sun.istack.internal.Nullable;

import java.util.*;


public class CardSet {

    private Comparator comparator;
    private ArrayList<Card> cards;

    public CardSet() {
        comparator = new CardComparator();
        cards = new ArrayList<>();
    }

    public void addCards(Collection<Card> cards) {
        this.cards.addAll(cards);
        Collections.sort(this.cards, comparator);
    }

    public void addCard(Card card) {
        cards.add(card);
        Collections.sort(this.cards, comparator);
    }

}
