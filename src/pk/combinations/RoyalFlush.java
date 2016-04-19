package pk.combinations;

import pk.model.Card;

import java.util.ArrayList;
import java.util.List;

public class RoyalFlush extends CardSet<RoyalFlush> {

    public RoyalFlush(List<Card> cards) {
        this.cards = new ArrayList<>();
        this.cards.addAll(cards);
    }

    @Override
    public int compareTo(RoyalFlush o) {
        throw new UnsupportedOperationException();
    }
}
