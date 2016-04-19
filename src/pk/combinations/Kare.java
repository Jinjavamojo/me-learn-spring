package pk.combinations;

import pk.model.Card;
import pk.model.Rank;

import java.util.ArrayList;
import java.util.List;


public class Kare extends CardSet<Kare>  {

    public Kare(List<Card> cards) {
        this.cards = new ArrayList<>();
        this.cards.addAll(cards);
    }

    public Rank getRank() {
        return cards.get(0).getRank();
    }

    @Override
    public int compareTo(Kare o) {
        if (this.cards.get(0).getRank().getValue() > o.cards.get(0).getRank().getValue())
            return 1;
        if (this.cards.get(0).getRank().getValue() < o.cards.get(0).getRank().getValue())
            return -1;
        throw  new RuntimeException("");
    }
}
