package pk.model;

import pk.combinations.CardSet;
import pk.model.Hand;


public class HandCardSet<T extends Comparable>  {

    private Hand hand;
    private CardSet someCombination;

    public HandCardSet(Hand hand, CardSet someCombination) {
        this.hand = hand;
        this.someCombination = someCombination;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public CardSet getSomeCombination() {
        return someCombination;
    }

    public void setSomeCombination(CardSet someCombination) {
        this.someCombination = someCombination;
    }



}
