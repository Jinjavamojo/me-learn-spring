package pk.comparators;

import pk.model.Card;

import java.util.Comparator;


public class DeckComparator implements Comparator {

    @Override
    public int compare(Object o, Object t1) {
        if (o instanceof Card && t1 instanceof Card) {
            Card o1 = (Card)o;
            Card o2 = (Card)t1;
            if (o1.getMast().getValue() + o1.getRank().getValue() == o2.getMast().getValue() + o2.getRank().getValue()) {
                return 0;
            }
            if (o1.getMast().getValue() + o1.getRank().getValue() > o2.getMast().getValue() + o2.getRank().getValue())
                return 1;
            else
                return -1;
        } else {
            throw new RuntimeException("");
        }
    }
}
