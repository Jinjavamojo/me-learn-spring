package pk.combinations;

import java.util.ArrayList;

public class TwoPairs extends CardSet {

    public final Pair firstPair;
    public final Pair secondPair;

    public TwoPairs(Pair firstPair, Pair secondPair) {
        cards = new ArrayList<>();
        this.firstPair = firstPair;
        this.secondPair = secondPair;
        cards.addAll(firstPair.getCards());
        cards.addAll(secondPair.getCards());
    }
}
