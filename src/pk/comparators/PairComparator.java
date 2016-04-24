package pk.comparators;

import pk.model.HandCardSet;
import pk.combinations.Pair;

import java.util.Comparator;


public class PairComparator<T> implements Comparator<T> {

    @Override
    public int compare(T o, T t1) {
        if (o instanceof Pair && t1 instanceof Pair) {
            Pair pair1 = (Pair)o;
            Pair pair2 = (Pair)t1;
            if (pair1.getWeight() >  pair2.getWeight())
                return -1;
            if (pair1.getWeight() < pair2.getWeight())
                return 1;
            return 0;
        }
        throw new RuntimeException();
    }
}
