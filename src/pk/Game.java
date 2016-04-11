package pk;

import java.util.*;

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
public class Game {

    private static TreeSet<Card> deck;

    public static void main(String[] args) {
        deck = new TreeSet<>(new CardComparator());
        Hand hand1 = new Hand();
        List<Mast> allMasts = Arrays.asList(Mast.values());
        List<Rank> allRanks = Arrays.asList(Rank.values());
        for (Mast mast : allMasts) {
            for (Rank rank : allRanks) {
                deck.add(new Card(rank,mast));
            }
        }

        Hand hand2 = new Hand();

        //set init cards for all hands
        //hand1.setFirstCard();


    }
}
