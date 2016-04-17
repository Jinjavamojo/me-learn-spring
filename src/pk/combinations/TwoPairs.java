package pk.combinations;

import java.util.ArrayList;

public class TwoPairs extends CardSet<TwoPairs> {

    public final Pair firstPair;
    public final Pair secondPair;

    public TwoPairs(Pair firstPair, Pair secondPair) {
        cards = new ArrayList<>();
        this.firstPair = firstPair;
        this.secondPair = secondPair;
        cards.addAll(firstPair.getCards());
        cards.addAll(secondPair.getCards());
    }

    @Override
    public int compareTo(TwoPairs o) {
        return 0;
    }
}
