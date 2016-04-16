package pk.combinations;

import pk.model.Card;

import java.util.ArrayList;
import java.util.List;


public class Triple extends CardSet {

    public final Card card1;
    public final Card card2;
    public final Card card3;

    public Triple(Card card1, Card card2, Card card3) {
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
    }

    public List<Card> getList() {
        ArrayList<Card> list = new ArrayList<Card>();
        list.add(card1);
        list.add(card2);
        list.add(card3);
        return list;
    }
}
