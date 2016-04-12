package pk;

import pk.combinations.*;

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
public class Combination {

    public static Pair hasPair(List<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            Card card1 = cards.get(i);
            for (int j = i+1; j < cards.size(); j++) {
                Card card2 = cards.get(j);
                if (card1.getRank().equals(card2.getRank())) {
                    return new Pair(card1,card2);
                }
            }
        }
        return null;
    }

    public static TwoPairs hasTwoPairs(List<Card> cards) {
        Pair pair = hasPair(cards);
        if (pair != null) {
            ArrayList<Card> cloned = new ArrayList<>(cards);
            cloned.remove(pair.card1);
            cloned.remove(pair.card2);
            Pair secondPair = hasPair(cloned);
            if (secondPair != null) {
                return new TwoPairs(pair, secondPair);
            }
        }
        return null;
    }

    public static Sets hasSet(List<Card> cards) {
        Pair pair = hasPair(cards);
        ArrayList<Card> cloned = new ArrayList<>(cards);
        cloned.remove(pair.card1);
        cloned.remove(pair.card2);
        Card card = containRank(pair.card1.getRank(), cloned);
        if (card != null) {
            return new Sets(pair.card1, pair.card2, card);
        }
        return null;
    }

    public static Kare hasKare(List<Card> cards) {
        Sets sets = hasSet(cards);
        ArrayList<Card> temp = new ArrayList<Card>(cards);
        temp.removeAll(sets.getList());
        Card fourthCard = containRank(sets.card1.getRank(), temp);
        ArrayList<Card> kareList = new ArrayList<Card>(sets.getList());
        kareList.add(fourthCard);
        return new Kare(kareList);
    }

    public Street hasStreet(List<Card> cards) {

    }


    private static Card containRank(Rank rank,List<Card> cards) {
        for (Card card : cards) {
            if (card.getRank().equals(rank))
                return card;
        }
        return null;
    }


}
