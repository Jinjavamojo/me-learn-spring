package pk.combinations;

import pk.model.Card;
import pk.model.Rank;

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
public class Kare extends CardSet  {

    public Kare(List<Card> cards) {
        this.cards = new ArrayList<>();
        cards.addAll(cards);
    }

    public Rank getRank() {
        return cards.get(0).getRank();
    }

}
