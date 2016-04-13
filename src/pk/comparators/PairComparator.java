package pk.comparators;

import pk.model.HandCardSet;
import pk.combinations.Pair;

import java.util.Comparator;

/**
 * Copyright 2016 LANIT group.
 * http://www.lanit.ru/
 * <p/>
 * Repository path:    $HeadURL$
 * Last committed:     $Revision$
 * Last changed by:    $Author$
 * Last changed date:  $Date$
 * ID:                 $Id$
 */
public class PairComparator<T> implements Comparator<T> {

    @Override
    public int compare(T o, T t1) {
        if (o instanceof HandCardSet && t1 instanceof HandCardSet) {
            Pair pair1 = (Pair)((HandCardSet) o).getSomeCombination();
            Pair pair2 = (Pair)((HandCardSet)t1).getSomeCombination();
            if (pair1.getWeight() >  pair2.getWeight())
                return -1;
            if (pair1.getWeight() < pair2.getWeight())
                return 1;
            pair1.setHaveEqualPair(true);
            pair2.setHaveEqualPair(true);
            return 0;
        }
        throw new RuntimeException();
    }
}