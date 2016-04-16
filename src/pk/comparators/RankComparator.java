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
public class RankComparator implements Comparator<Card> {

    private boolean isAsc;

    public RankComparator(boolean order) {
        isAsc = order;
    }

    @Override
    public int compare(Card o1, Card o2) {
            if (o1.getRank().getValue() == o2.getRank().getValue()) {
                return 0;
            }
            if (o1.getRank().getValue() > o2.getRank().getValue()) {
                if (isAsc) {
                    return 1;
                }
                return -1;
            }
            else {
                if (isAsc) {
                    return -1;
                }
                return 1;
            }
    }
}
