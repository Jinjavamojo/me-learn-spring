package pk.combinations;

import pk.model.Card;

import java.util.ArrayList;
import java.util.List;


public class StreetFlush extends CardSet<StreetFlush> {

    public StreetFlush(List<Card> cards) {
        this.cards = new ArrayList<>();
        this.cards.addAll(cards);
    }

    @Override
    public int compareTo(StreetFlush o) {
        throw new UnsupportedOperationException();
    }
}
