package pk.model;

import pk.model.Hand;

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
public class HandCardSet<T> {

    private Hand hand;
    private T someCombination;

    public HandCardSet(Hand hand, T someCombination) {
        this.hand = hand;
        this.someCombination = someCombination;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public T getSomeCombination() {
        return someCombination;
    }

    public void setSomeCombination(T someCombination) {
        this.someCombination = someCombination;
    }
}
