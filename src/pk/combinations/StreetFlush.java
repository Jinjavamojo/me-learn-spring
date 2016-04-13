package pk.combinations;

import pk.model.Card;

import java.util.ArrayList;
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
public class StreetFlush extends CardSet {

    public StreetFlush(List<Card> cards) {
        this.cards = new ArrayList<>();
        cards.addAll(cards);
    }
}
