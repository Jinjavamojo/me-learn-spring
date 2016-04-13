package pk.comparators;

import pk.model.Card;

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
public class RankComparator implements Comparator {

    @Override
    public int compare(Object o, Object t1) {
        if (o instanceof Card && t1 instanceof Card) {
            Card o1 = (Card)o;
            Card o2 = (Card)t1;
            if (o1.getRank().getValue() == o2.getRank().getValue()) {
                return 0;
            }
            if (o1.getRank().getValue() > o2.getRank().getValue())
                return 1;
            else
                return -1;
        } else {
            throw new RuntimeException("");
        }
    }
}
