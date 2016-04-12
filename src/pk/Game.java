package pk;

import pk.view.SingleWindow;

import org.junit.Test;
import pk.combinations.Kare;
import pk.combinations.Pair;
import pk.combinations.Sets;
import pk.combinations.TwoPairs;

import java.util.*;


public class Game {
    

    public static void main(String[] args) {
    }

    @Test
    public void hasKare() {
        List<Card> c1 = new ArrayList<>();
        c1.add(new Card(Rank.JACK, Mast.PIKI));
        c1.add(new Card(Rank.JACK, Mast.BUBI));
        c1.add(new Card(Rank.JACK, Mast.KRESTI));
        c1.add(new Card(Rank.JACK, Mast.CHERVI));
        c1.add(new Card(Rank.ACE, Mast.CHERVI));
        Pair pair = Combination.hasPair(c1);
        TwoPairs twoPairs = Combination.hasTwoPairs(c1);
        Sets sets = Combination.hasSet(c1);
        Kare kare = Combination.hasKare(c1);
        int g=0;

    }

    @Test
    public void test() {
        ArrayList<Card> cards = initializeDeck();
        Hand hand1 = new Hand();
        CardSet cardSet = new CardSet();
        List<Card> c1 = new ArrayList<>();
        c1.add(new Card(Rank.JACK, Mast.PIKI));
        c1.add(new Card(Rank.JACK, Mast.BUBI));
        c1.add(new Card(Rank.ACE, Mast.KRESTI));
        c1.add(new Card(Rank.EIGHT, Mast.CHERVI));
        c1.add(new Card(Rank.ACE, Mast.CHERVI));
        cardSet.addCards(c1);
        Pair pair = Combination.hasPair(c1);
        TwoPairs pairs2 = Combination.hasTwoPairs(c1);
        int g = 0;
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
        Collections.sort(deck, new CardComparator());
        return deck;
    }
}
