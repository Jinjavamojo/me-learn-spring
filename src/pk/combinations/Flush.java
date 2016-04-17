package pk.combinations;

import pk.model.Card;

import java.util.ArrayList;
import java.util.List;


public class Flush extends CardSet<Flush> {
    public Flush(List<Card> cards) {
        this.cards = new ArrayList<>();
        this.cards.addAll(cards);
    }

    @Override
    public int compareTo(Flush o) {
        return 0;
    }
}
