package pk.combinations;

import pk.model.Rank;

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
        //Если два или более игроков имеют две пары, то выиграет та рука, старшая пара которой старше.
        int thisMaxValueOfTwoPairs = firstPair.getCard1().getRank().getValue();
        int thisMinValueOfTwoPairs ;
        if (secondPair.getCard1().getRank().getValue() > thisMaxValueOfTwoPairs) {
            thisMaxValueOfTwoPairs = secondPair.getCard1().getRank().getValue();
            thisMinValueOfTwoPairs = firstPair.getCard1().getRank().getValue();
        } else {
            thisMinValueOfTwoPairs = secondPair.getCard1().getRank().getValue();
        }
        int otherMaxValueOfTwoPairs = o.getFirstPair().getCard1().getRank().getValue();
        int otherMinValueOfTwoPairs ;
        if (o.getSecondPair().getCard1().getRank().getValue() > otherMaxValueOfTwoPairs) {
            otherMaxValueOfTwoPairs = o.getSecondPair().getCard1().getRank().getValue();
            otherMinValueOfTwoPairs = o.getFirstPair().getCard1().getRank().getValue();
        } else {
            otherMinValueOfTwoPairs = o.getSecondPair().getCard1().getRank().getValue();
        }
        if (thisMaxValueOfTwoPairs > otherMaxValueOfTwoPairs)
            return 1;
        if (thisMaxValueOfTwoPairs < otherMaxValueOfTwoPairs)
            return -1;

        //this case then 1 pair of 1 hand equal 2 pair of 2 hand.
        if (thisMinValueOfTwoPairs > otherMinValueOfTwoPairs)
            return 1;
        if (thisMinValueOfTwoPairs < otherMinValueOfTwoPairs)
            return -1;
        return 0;
    }

    public Pair getFirstPair() {
        return firstPair;
    }

    public Pair getSecondPair() {
        return secondPair;
    }
}
