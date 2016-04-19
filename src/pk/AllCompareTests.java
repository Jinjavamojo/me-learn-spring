package pk;

import org.junit.Assert;
import pk.combinations.*;

import org.junit.Test;
import pk.model.*;
import pk.view.SingleWindow;

import java.util.*;


public class AllCompareTests extends Assert {
    

    public static void main(String[] args) {
        SingleWindow w = new SingleWindow();
    }

    @Test
    public void hasKareSets() {
        List<Card> c1 = new ArrayList<>();
        c1.add(new Card(Rank.JACK, Mast.PIKI));
        c1.add(new Card(Rank.JACK, Mast.BUBI));
        c1.add(new Card(Rank.JACK, Mast.KRESTI));
        c1.add(new Card(Rank.JACK, Mast.CHERVI));
        c1.add(new Card(Rank.ACE, Mast.CHERVI));
        Triple triple = CombinationHelper.hasTriple(c1);
        Kare kare = CombinationHelper.hasKare(c1);
        assertNotNull(triple);
        assertNotNull(kare);
    }

//    @Test
//    public void hasPairs() {
//        List<Card> c1 = new ArrayList<>();
//        c1.add(new Card(Rank.JACK, Mast.PIKI));
//        c1.add(new Card(Rank.JACK, Mast.BUBI));
//        c1.add(new Card(Rank.ACE, Mast.KRESTI));
//        c1.add(new Card(Rank.EIGHT, Mast.CHERVI));
//        c1.add(new Card(Rank.ACE, Mast.CHERVI));
//        Pair pair = CombinationHelper.hasPair(c1);
//        assertNotNull(pair);
//        TwoPairs pairs2 = CombinationHelper.hasTwoPairs(c1);
//        assertNotNull(pairs2);
//    }


    @Test
    public void hasStreet() {
        List<Card> c1 = new ArrayList<>();
        c1.add(new Card(Rank.TWO, Mast.PIKI));
        c1.add(new Card(Rank.ACE, Mast.PIKI));
        c1.add(new Card(Rank.SIX, Mast.BUBI));
        c1.add(new Card(Rank.FIVE, Mast.KRESTI));
        c1.add(new Card(Rank.THREE, Mast.CHERVI));
        c1.add(new Card(Rank.FOUR, Mast.CHERVI));
        Street street = CombinationHelper.hasStreet(c1);
        assertNotNull(street);
        List<Card> c2 = new ArrayList<>();
        c2.add(new Card(Rank.QUEEN, Mast.PIKI));
        c2.add(new Card(Rank.TEN, Mast.BUBI));
        c2.add(new Card(Rank.JACK, Mast.KRESTI));
        c2.add(new Card(Rank.TEN, Mast.CHERVI));
        c2.add(new Card(Rank.NINE, Mast.CHERVI));
        c2.add(new Card(Rank.KING, Mast.CHERVI));
        Street street2 = CombinationHelper.hasStreet(c2);
        assertNotNull(street2);
        List<Card> c3 = new ArrayList<>();
        c3.add(new Card(Rank.QUEEN, Mast.PIKI));
        c3.add(new Card(Rank.TEN, Mast.BUBI));
        c3.add(new Card(Rank.JACK, Mast.KRESTI));
        c3.add(new Card(Rank.TEN, Mast.CHERVI));
        c3.add(new Card(Rank.NINE, Mast.CHERVI));
        c3.add(new Card(Rank.ACE, Mast.CHERVI));
        Street street3 = CombinationHelper.hasStreet(c3);
        assertNull(street3);
    }



    public void tryGame() {
        final ArrayList<Card> cards = CombinationHelper.initializeDeck();
        Hand hand1 = new Hand(1);
        Hand hand2 = new Hand(2);
        List<Card> afterFlop = new ArrayList<>();

        //initialize 4 card
        afterFlop.add(new Card(Rank.TWO,Mast.PIKI));
        afterFlop.add(new Card(Rank.TEN,Mast.PIKI));
        afterFlop.add(new Card(Rank.ACE, Mast.BUBI));
        afterFlop.add(new Card(Rank.EIGHT, Mast.BUBI));

        //initialize hands
        hand1.initializeCards(new Card(Rank.NINE, Mast.CHERVI), new Card(Rank.JACK, Mast.BUBI));
        hand2.initializeCards(new Card(Rank.TEN, Mast.KRESTI), new Card(Rank.TEN, Mast.PIKI));


    }

    @Test
    public void compareTwoPairs() {
        Hand hand1 = new Hand(1);
        Hand hand2 = new Hand(2);
        List<Card> river = new ArrayList<>();

        //initialize 4 card
        river.add(new Card(Rank.TWO, Mast.PIKI));
        river.add(new Card(Rank.ACE, Mast.KRESTI));
        river.add(new Card(Rank.THREE, Mast.BUBI));
        river.add(new Card(Rank.JACK, Mast.BUBI));
        river.add(new Card(Rank.TEN, Mast.BUBI));

        //initialize hands
        hand1.initializeCards(new Card(Rank.TWO, Mast.CHERVI), new Card(Rank.JACK, Mast.PIKI));
        hand2.initializeCards(new Card(Rank.THREE, Mast.KRESTI), new Card(Rank.TEN, Mast.PIKI));

        List<Card> c1 = new ArrayList<>(river);
        c1.addAll(hand1.getCards());
        List<Card> c2 = new ArrayList<>(river);
        c2.addAll(hand2.getCards());
        TwoPairs twoPairs1 = CombinationHelper.hasTwoPairs(c1);
        TwoPairs twoPairs2 = CombinationHelper.hasTwoPairs(c2);
        int i = twoPairs1.compareTo(twoPairs2);
        int i2 = twoPairs2.compareTo(twoPairs1);
        assertEquals(i,1);
        assertEquals(i2, -1);

        river.clear();
        river.add(new Card(Rank.TWO, Mast.PIKI));
        river.add(new Card(Rank.ACE, Mast.KRESTI));
        river.add(new Card(Rank.ACE, Mast.BUBI));
        river.add(new Card(Rank.JACK, Mast.BUBI));
        river.add(new Card(Rank.TEN, Mast.BUBI));

        hand1.initializeCards(new Card(Rank.TWO, Mast.CHERVI), new Card(Rank.KING, Mast.PIKI));
        hand2.initializeCards(new Card(Rank.THREE, Mast.KRESTI), new Card(Rank.TEN, Mast.PIKI));
        c1 = new ArrayList<>(river);
        c1.addAll(hand1.getCards());
        c2 = new ArrayList<>(river);
        c2.addAll(hand2.getCards());
        twoPairs1 = CombinationHelper.hasTwoPairs(c1);
        twoPairs2 = CombinationHelper.hasTwoPairs(c2);
        i = twoPairs1.compareTo(twoPairs2);
        i2 = twoPairs2.compareTo(twoPairs1);
        assertEquals(i, -1);
        assertEquals(i2, 1);
    }

    @Test
    public void comparePairs() {
        Hand hand1 = new Hand(1);
        Hand hand2 = new Hand(2);
        Hand hand3 = new Hand(3);
        Hand hand4 = new Hand(4);
        hand1.initializeCards(new Card(Rank.TWO, Mast.CHERVI), new Card(Rank.TWO, Mast.PIKI));
        hand2.initializeCards(new Card(Rank.FOUR, Mast.KRESTI), new Card(Rank.TEN, Mast.PIKI));
        hand3.initializeCards(new Card(Rank.NINE, Mast.KRESTI), new Card(Rank.NINE, Mast.PIKI));
        hand4.initializeCards(new Card(Rank.KING, Mast.KRESTI), new Card(Rank.FOUR, Mast.BUBI));
        List<Card> river = new ArrayList<>();


        //initialize 4 card
        river.add(new Card(Rank.THREE, Mast.PIKI));
        river.add(new Card(Rank.ACE, Mast.KRESTI));
        river.add(new Card(Rank.ACE, Mast.BUBI));
        river.add(new Card(Rank.FOUR, Mast.CHERVI));
        river.add(new Card(Rank.QUEEN, Mast.BUBI));

        CombinationsForOneCard combinationsForOneCard = new CombinationsForOneCard();
        combinationsForOneCard.addPair(new HandCardSet<Pair>(hand1,CombinationHelper.hasPair(new ArrayList<Card>(hand1.getCards()),river)));
        combinationsForOneCard.addPair(new HandCardSet<Pair>(hand2,CombinationHelper.hasPair(new ArrayList<Card>(hand2.getCards()),river)));
        combinationsForOneCard.addPair(new HandCardSet<Pair>(hand3,CombinationHelper.hasPair(new ArrayList<Card>(hand3.getCards()),river)));
        combinationsForOneCard.addPair(new HandCardSet<Pair>(hand4,CombinationHelper.hasPair(new ArrayList<Card>(hand4.getCards()),river)));

        int g = 0;
    }
}
