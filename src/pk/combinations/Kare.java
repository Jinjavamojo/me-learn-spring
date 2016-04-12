package pk.combinations;

import pk.Card;
import pk.Rank;

import java.util.List;

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
public class Kare {


    public List<Card> cards;

    public Kare(List<Card> cards) {
        this.cards = cards;
    }

    public Rank getRank() {
        return cards.get(0).getRank();
    }

}
