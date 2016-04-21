package pk.combinations;

import pk.model.Card;

import java.util.ArrayList;
import java.util.List;


public class Triple extends CardSet<Triple> {

    public Triple(List<Card> cards) {
        this.cards = new ArrayList<>();
        this.cards.addAll(cards);
    }

    @Override
    public int compareTo(Triple o) {
        //enough compare one card 'cause all three cards have some rank
        return this.getCards().get(0).getRank().compareTo(o.getCards().get(0).getRank());

    }
}
