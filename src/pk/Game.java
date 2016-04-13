package pk;

import org.junit.Assert;
import pk.combinations.*;

import org.junit.Test;
import pk.comparators.DeckComparator;
import pk.model.*;

import java.util.*;


public class Game extends Assert {
    

    public static void main(String[] args) {
    }

    @Test
    public void hasKareSets() {
        List<Card> c1 = new ArrayList<>();
        c1.add(new Card(Rank.JACK, Mast.PIKI));
        c1.add(new Card(Rank.JACK, Mast.BUBI));
        c1.add(new Card(Rank.JACK, Mast.KRESTI));
        c1.add(new Card(Rank.JACK, Mast.CHERVI));
        c1.add(new Card(Rank.ACE, Mast.CHERVI));
        Triple triple = CombinationHelper.hasSet(c1);
        Kare kare = CombinationHelper.hasKare(c1);
        assertNotNull(triple);
        assertNotNull(kare);
    }

    @Test
    public void hasPairs() {
        List<Card> c1 = new ArrayList<>();
        c1.add(new Card(Rank.JACK, Mast.PIKI));
        c1.add(new Card(Rank.JACK, Mast.BUBI));
        c1.add(new Card(Rank.ACE, Mast.KRESTI));
        c1.add(new Card(Rank.EIGHT, Mast.CHERVI));
        c1.add(new Card(Rank.ACE, Mast.CHERVI));
        Pair pair = CombinationHelper.hasPair(c1);
        assertNotNull(pair);
        TwoPairs pairs2 = CombinationHelper.hasTwoPairs(c1);
        assertNotNull(pairs2);
    }


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

    public static ArrayList<Card> initializeDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        List<Mast> allMasts = Arrays.asList(Mast.values());
        List<Rank> allRanks = Arrays.asList(Rank.values());
        for (Mast mast : allMasts) {
            for (Rank rank : allRanks) {
                deck.add(new Card(rank, mast));
            }
        }
        Collections.sort(deck, new DeckComparator());
        return deck;
    }

    public void tryGame() {
        final ArrayList<Card> cards = initializeDeck();
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

    public void doMagic(List<Hand> hands, List<Card> afterFlop) {
        ArrayList<Card> deck = initializeDeck();
        for (Hand hand : hands) {
            deck.removeAll(hand.getCards());
        }
        deck.removeAll(afterFlop);
        List<HandCardSet> allCombs = new ArrayList<>();
        for (Card card : deck) {
            CombinationsForOneCard combinationsForOneCard = new CombinationsForOneCard();
            for (Hand hand : hands) {
                ArrayList<Card> cardSet = new ArrayList<>(hand.getCards());
                cardSet.addAll(afterFlop);
                cardSet.add(card);
                Pair pair = CombinationHelper.hasPair(cardSet);
                TwoPairs twoPairs = CombinationHelper.hasTwoPairs(cardSet);
                Triple triple = CombinationHelper.hasSet(cardSet);
                Street street = CombinationHelper.hasStreet(cardSet);
                Flush flush = CombinationHelper.hasFlush(cardSet);
                FullHouse fullHouse = CombinationHelper.hasFullHouse(cardSet);
                Kare kare = CombinationHelper.hasKare(cardSet);
                StreetFlush streetFlush = CombinationHelper.hasStreetFlush(cardSet);
                RoyalFlush royalFlush = CombinationHelper.hasRoyalFlush(cardSet);

                if (pair != null)
                    combinationsForOneCard.addPair(new HandCardSet<>(hand, pair));
                if (twoPairs != null)
                    combinationsForOneCard.addTwoPair(new HandCardSet<>(hand, twoPairs));
                if (triple != null)
                    combinationsForOneCard.addTriple(new HandCardSet<>(hand, triple));
                if (street != null)
                    combinationsForOneCard.addStreet(new HandCardSet<>(hand, street));
                if (flush != null)
                    combinationsForOneCard.addFlush(new HandCardSet<Flush>(hand, flush));
                if (fullHouse != null)
                    combinationsForOneCard.addFullHouse(new HandCardSet<FullHouse>(hand, fullHouse));
                if (kare != null)
                    combinationsForOneCard.addKare(new HandCardSet<>(hand, kare));
                if (streetFlush != null)
                    combinationsForOneCard.addStreetFlush(new HandCardSet<StreetFlush>(hand, streetFlush));
                if (royalFlush != null)
                    combinationsForOneCard.addRoyalFlush(new HandCardSet<RoyalFlush>(hand, royalFlush));
            }
            allCombs.addAll(combinationsForOneCard.getOnlyBestWinnerCombination());
        }
    }
}
