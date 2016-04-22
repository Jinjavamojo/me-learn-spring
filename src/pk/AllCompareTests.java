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

    //tested
    @Test
    public void hasKareSets() {
        //can be care at turn (4 of 5)
        Hand hand1 = new Hand(1);
        Hand hand2 = new Hand(2);
        hand1.initializeCards(new Card(Rank.TWO, Mast.CHERVI), new Card(Rank.JACK, Mast.PIKI));
        hand2.initializeCards(new Card(Rank.THREE, Mast.KRESTI), new Card(Rank.TEN, Mast.PIKI));
        List<Card> turn = new ArrayList<>();
        turn.add(new Card(Rank.JACK, Mast.PIKI));
        turn.add(new Card(Rank.JACK, Mast.BUBI));
        turn.add(new Card(Rank.JACK, Mast.KRESTI));
        turn.add(new Card(Rank.JACK, Mast.CHERVI));
        turn.add(new Card(Rank.ACE, Mast.CHERVI));
        Kare kare1 = CombinationHelper.hasKare(hand1.getCards(),turn);
        Kare kare2 = CombinationHelper.hasKare(hand2.getCards(),turn);
        assertNull(kare1);
        assertNull(kare2);

        //1+3
        hand1 = new Hand(1);
        hand1.initializeCards(new Card(Rank.KING, Mast.CHERVI), new Card(Rank.TWO, Mast.PIKI));
        turn = new ArrayList<>();
        turn.add(new Card(Rank.KING, Mast.PIKI));
        turn.add(new Card(Rank.KING, Mast.BUBI));
        turn.add(new Card(Rank.KING, Mast.KRESTI));
        turn.add(new Card(Rank.TWO, Mast.CHERVI));
        turn.add(new Card(Rank.FOUR, Mast.CHERVI));
         kare1 = CombinationHelper.hasKare(hand1.getCards(),turn);
        assertNotNull(kare1);

        //2+2
        hand1 = new Hand(1);
        hand1.initializeCards(new Card(Rank.KING, Mast.CHERVI), new Card(Rank.KING, Mast.PIKI));
        turn = new ArrayList<>();
        turn.add(new Card(Rank.ACE, Mast.PIKI));
        turn.add(new Card(Rank.KING, Mast.BUBI));
        turn.add(new Card(Rank.KING, Mast.KRESTI));
        turn.add(new Card(Rank.ACE, Mast.CHERVI));
        turn.add(new Card(Rank.FOUR, Mast.CHERVI));
        kare1 = CombinationHelper.hasKare(hand1.getCards(),turn);
        assertNotNull(kare1);
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

    //todo completed
    @Test
    public void hasStreet() {
        //test minor street, A 2 3 4 5
        Hand hand1 = new Hand(1);
        hand1.initializeCards(new Card(Rank.TWO, Mast.CHERVI), new Card(Rank.ACE, Mast.PIKI));
        List<Card> c1 = new ArrayList<>();
        c1.add(new Card(Rank.QUEEN, Mast.BUBI));
        c1.add(new Card(Rank.FIVE, Mast.KRESTI));
        c1.add(new Card(Rank.THREE, Mast.CHERVI));
        c1.add(new Card(Rank.FOUR, Mast.CHERVI));
        Street street = CombinationHelper.hasStreet(hand1.getCards(), c1);
        assertNotNull(street);
        //test usual street, 9 10 J Q K
        List<Card> c2 = new ArrayList<>();
        hand1.initializeCards(new Card(Rank.QUEEN, Mast.PIKI), new Card(Rank.TEN, Mast.BUBI));
        c2.add(new Card(Rank.JACK, Mast.KRESTI));
        c2.add(new Card(Rank.TEN, Mast.CHERVI));
        c2.add(new Card(Rank.NINE, Mast.CHERVI));
        c2.add(new Card(Rank.KING, Mast.CHERVI));
        Street street2 = CombinationHelper.hasStreet(hand1.getCards(), c2);
        assertNotNull(street2);
        //test not street
        List<Card> c3 = new ArrayList<>();
        hand1.initializeCards(new Card(Rank.QUEEN, Mast.PIKI), new Card(Rank.JACK, Mast.BUBI));
        c3.add(new Card(Rank.JACK, Mast.KRESTI));
        c3.add(new Card(Rank.TEN, Mast.CHERVI));
        c3.add(new Card(Rank.NINE, Mast.CHERVI));
        c3.add(new Card(Rank.ACE, Mast.CHERVI));
        Street street3 = CombinationHelper.hasStreet(hand1.getCards(), c3);
        assertNull(street3);


        c3 = new ArrayList<>();
        hand1.initializeCards(new Card(Rank.QUEEN, Mast.PIKI), new Card(Rank.JACK, Mast.BUBI));
        c3.add(new Card(Rank.TWO, Mast.KRESTI));
        c3.add(new Card(Rank.THREE, Mast.CHERVI));
        c3.add(new Card(Rank.FOUR, Mast.CHERVI));
        c3.add(new Card(Rank.FIVE, Mast.CHERVI));
        c3.add(new Card(Rank.SIX, Mast.CHERVI));
        Street street4 = CombinationHelper.hasStreet(hand1.getCards(), c3);
        assertNull(street4);


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

    //todo completed
    @Test
    public void compareTwoPairs() {
        Hand hand1 = new Hand(1);
        Hand hand2 = new Hand(2);

        List<Card> river = new ArrayList<>();
        river.add(new Card(Rank.TWO, Mast.PIKI));
        river.add(new Card(Rank.ACE, Mast.KRESTI));
        river.add(new Card(Rank.THREE, Mast.BUBI));
        river.add(new Card(Rank.JACK, Mast.BUBI));
        river.add(new Card(Rank.TEN, Mast.BUBI));

        //initialize hands
        hand1.initializeCards(new Card(Rank.TWO, Mast.CHERVI), new Card(Rank.JACK, Mast.PIKI));
        hand2.initializeCards(new Card(Rank.THREE, Mast.KRESTI), new Card(Rank.TEN, Mast.PIKI));

        TwoPairs twoPairs1 = CombinationHelper.hasTwoPairs(hand1.getCards(), river);
        TwoPairs twoPairs2 = CombinationHelper.hasTwoPairs(hand2.getCards(), river);
        assertNotNull(twoPairs1);
        assertNotNull(twoPairs2);
        int i = twoPairs1.compareTo(twoPairs2);
        int i2 = twoPairs2.compareTo(twoPairs1);

        //test 2+2 and J+J > 3+3 and 10+10
        assertEquals(i, 1);
        assertEquals(i2, -1);

        river.clear();
        river.add(new Card(Rank.TWO, Mast.PIKI));
        river.add(new Card(Rank.ACE, Mast.KRESTI));
        river.add(new Card(Rank.ACE, Mast.BUBI));
        river.add(new Card(Rank.JACK, Mast.BUBI));
        river.add(new Card(Rank.TEN, Mast.BUBI));

        hand1.initializeCards(new Card(Rank.TWO, Mast.CHERVI), new Card(Rank.KING, Mast.PIKI));
        hand2.initializeCards(new Card(Rank.THREE, Mast.KRESTI), new Card(Rank.TEN, Mast.PIKI));
        twoPairs1 = CombinationHelper.hasTwoPairs(hand1.getCards(), river);
        twoPairs2 = CombinationHelper.hasTwoPairs(hand2.getCards(), river);
        assertNotNull(twoPairs1);
        assertNotNull(twoPairs2);
        i = twoPairs1.compareTo(twoPairs2);
        i2 = twoPairs2.compareTo(twoPairs1);
        //test 2+2 and A+A  <  10+10 and A+A
        assertEquals(i, -1);
        assertEquals(i2, 1);


        //now test very hard example. two pair on river
        river.clear();
        river.add(new Card(Rank.EIGHT, Mast.PIKI));
        river.add(new Card(Rank.ACE, Mast.KRESTI));
        river.add(new Card(Rank.ACE, Mast.BUBI));
        river.add(new Card(Rank.KING, Mast.BUBI));
        river.add(new Card(Rank.KING, Mast.BUBI));
        hand1.initializeCards(new Card(Rank.TWO, Mast.CHERVI), new Card(Rank.TWO, Mast.PIKI));
        hand2.initializeCards(new Card(Rank.FOUR, Mast.KRESTI), new Card(Rank.FOUR, Mast.PIKI));
        twoPairs1 = CombinationHelper.hasTwoPairs(hand1.getCards(), river);
        twoPairs2 = CombinationHelper.hasTwoPairs(hand2.getCards(), river);
        assertNotNull(twoPairs1);
        assertNotNull(twoPairs2);
        i = twoPairs1.compareTo(twoPairs2);
        i2 = twoPairs2.compareTo(twoPairs1);
        assertEquals(i, -1);
        assertEquals(i2, 1);

        river.clear();
        river.add(new Card(Rank.TWO, Mast.PIKI));
        river.add(new Card(Rank.ACE, Mast.KRESTI));
        river.add(new Card(Rank.ACE, Mast.BUBI));
        river.add(new Card(Rank.JACK, Mast.BUBI));
        river.add(new Card(Rank.FOUR, Mast.BUBI));
        hand1.initializeCards(new Card(Rank.TWO, Mast.CHERVI), new Card(Rank.KING, Mast.PIKI));
        hand2.initializeCards(new Card(Rank.FOUR, Mast.KRESTI), new Card(Rank.JACK, Mast.PIKI));
        twoPairs1 = CombinationHelper.hasTwoPairs(hand1.getCards(), river);
        twoPairs2 = CombinationHelper.hasTwoPairs(hand2.getCards(), river);
        assertNotNull(twoPairs1);
        assertNotNull(twoPairs2);
        CombinationsForOneCard combinationsForOneCard = new CombinationsForOneCard();
        combinationsForOneCard.addTwoPair(new HandCardSet<TwoPairs>(hand1, twoPairs1));
        combinationsForOneCard.addTwoPair(new HandCardSet<TwoPairs>(hand2, twoPairs2));
        Collection<HandCardSet> onlyBestWinnerCombination = combinationsForOneCard.getOnlyBestWinnerCombination();
        assertEquals(onlyBestWinnerCombination.size(),1);
        assertEquals(onlyBestWinnerCombination.iterator().next().getHand().getNumber(), 2);
        int g = 0;
    }

    @Test
    public void comparePairs() {
        Hand hand1 = new Hand(1);
        Hand hand2 = new Hand(2);
        Hand hand3 = new Hand(3);
        hand1.initializeCards(new Card(Rank.TWO, Mast.CHERVI), new Card(Rank.TWO, Mast.PIKI));
        hand2.initializeCards(new Card(Rank.FOUR, Mast.KRESTI), new Card(Rank.FOUR, Mast.PIKI));
        hand3.initializeCards(new Card(Rank.NINE, Mast.KRESTI), new Card(Rank.TWO, Mast.BUBI));
        List<Card> river = new ArrayList<>();

        //initialize 4 card
        river.add(new Card(Rank.NINE, Mast.PIKI));
        river.add(new Card(Rank.ACE, Mast.KRESTI));
        river.add(new Card(Rank.ACE, Mast.BUBI));
        river.add(new Card(Rank.FOUR, Mast.CHERVI));
        river.add(new Card(Rank.QUEEN, Mast.BUBI));
        Pair pair1 = CombinationHelper.hasPair(hand1.getCards(), river, false);
        Pair pair2 = CombinationHelper.hasPair(hand2.getCards(), river, false);
        Pair pair3 = CombinationHelper.hasPair(hand3.getCards(), river, false);
        assertEquals(pair1.compareTo(pair2), -1);
        assertEquals(pair2.compareTo(pair1), 1);
        assertEquals(pair1.compareTo(pair3), -1);
        assertEquals(pair3.compareTo(pair1), 1);
    }

    @Test
    public void equalsCardSets() {
        List<Card> flushCards1 = new ArrayList<>();
        flushCards1.add(new Card(Rank.FIVE,Mast.BUBI));
        flushCards1.add(new Card(Rank.FOUR,Mast.BUBI));
        flushCards1.add(new Card(Rank.THREE,Mast.BUBI));
        flushCards1.add(new Card(Rank.TWO,Mast.BUBI));
        flushCards1.add(new Card(Rank.TEN,Mast.BUBI));
        Flush c1 = new Flush(flushCards1);
        List<Card> flushCards2 = new ArrayList<>();
        flushCards2.add(new Card(Rank.FIVE,Mast.BUBI));
        flushCards2.add(new Card(Rank.FOUR, Mast.BUBI));
        flushCards2.add(new Card(Rank.THREE, Mast.BUBI));
        flushCards2.add(new Card(Rank.TWO, Mast.BUBI));
        flushCards2.add(new Card(Rank.TEN, Mast.BUBI));
        Flush c2 = new Flush(flushCards2);
        assertEquals(c1, c2);

        flushCards1 = new ArrayList<>();
        flushCards1.add(new Card(Rank.FIVE,Mast.BUBI));
        flushCards1.add(new Card(Rank.FOUR,Mast.BUBI));
        flushCards1.add(new Card(Rank.THREE,Mast.BUBI));
        flushCards1.add(new Card(Rank.TWO, Mast.BUBI));
        flushCards1.add(new Card(Rank.TEN, Mast.BUBI));
        flushCards2 = new ArrayList<>();
        flushCards2.add(new Card(Rank.FIVE, Mast.BUBI));
        flushCards2.add(new Card(Rank.FOUR, Mast.BUBI));
        flushCards2.add(new Card(Rank.THREE,Mast.BUBI));
        flushCards2.add(new Card(Rank.TWO,Mast.BUBI));
        flushCards2.add(new Card(Rank.TEN, Mast.PIKI));
        c1 = new Flush(flushCards1);
        c2 = new Flush(flushCards2);
        assertNotEquals(c1, c2);

        flushCards1 = new ArrayList<>();
        flushCards1.add(new Card(Rank.FIVE,Mast.BUBI));
        flushCards1.add(new Card(Rank.FOUR,Mast.BUBI));
        flushCards2 = new ArrayList<>();
        flushCards2.add(new Card(Rank.FIVE,Mast.BUBI));
        flushCards2.add(new Card(Rank.FOUR, Mast.BUBI));
        flushCards2.add(new Card(Rank.THREE,Mast.BUBI));
        flushCards2.add(new Card(Rank.TWO, Mast.BUBI));
        flushCards2.add(new Card(Rank.TEN, Mast.PIKI));
        c1 = new Flush(flushCards1);
        c2 = new Flush(flushCards2);
        assertNotEquals(c1, c2);

        flushCards1 = new ArrayList<>();
        flushCards1.add(new Card(Rank.FIVE,Mast.BUBI));
        flushCards1.add(new Card(Rank.FOUR,Mast.BUBI));
        flushCards2 = new ArrayList<>();
        flushCards2.add(new Card(Rank.FIVE,Mast.BUBI));
        flushCards2.add(new Card(Rank.ACE, Mast.BUBI));
        c1 = new Flush(flushCards1);
        c2 = new Flush(flushCards2);
        assertNotEquals(c1, c2);

        flushCards1 = new ArrayList<>();
        flushCards1.add(new Card(Rank.FIVE,Mast.BUBI));
        flushCards1.add(new Card(Rank.FOUR,Mast.BUBI));
        flushCards2 = new ArrayList<>();
        flushCards2.add(new Card(Rank.FIVE,Mast.BUBI));
        c1 = new Flush(flushCards1);
        c2 = new Flush(flushCards2);
        assertNotEquals(c1, c2);

        flushCards1 = new ArrayList<>();
        flushCards1.add(new Card(Rank.FIVE,Mast.BUBI));
        flushCards1.add(new Card(Rank.FOUR,Mast.BUBI));
        flushCards2 = new ArrayList<>();
        flushCards2.add(new Card(Rank.FOUR,Mast.BUBI));
        flushCards2.add(new Card(Rank.FIVE,Mast.BUBI));
        c1 = new Flush(flushCards1);
        c2 = new Flush(flushCards2);
        assertEquals(c1, c2);
    }
}
