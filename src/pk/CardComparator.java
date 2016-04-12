package pk;

import java.util.Comparator;


public class CardComparator implements Comparator {

    @Override
    public int compare(Object o, Object t1) {
        if (o instanceof Card && t1 instanceof Card) {
            Card o1 = (Card)o;
            Card o2 = (Card)t1;
            if (o1.getMast().value + o1.getRank().value == o2.getMast().value + o2.getRank().value) {
                return 0;
            }
            if (o1.getMast().value + o1.getRank().value > o2.getMast().value + o2.getRank().value)
                return 1;
            else
                return -1;
        } else {
            throw new RuntimeException("");
        }
    }
}
