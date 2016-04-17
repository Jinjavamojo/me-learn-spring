package pk;

import pk.combinations.*;
import pk.comparators.DeckComparator;
import pk.comparators.RankComparator;
import pk.model.*;

import java.util.*;


public class CombinationHelper {

    private static Comparator<Card> ascRankComparator = new RankComparator(true);
    private static Comparator<Card> descRankComparator = new RankComparator(false);

    public static Pair hasPair(List<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            Card card1 = cards.get(i);
            for (int j = i + 1; j < cards.size(); j++) {
                Card card2 = cards.get(j);
                if (card1.getRank().equals(card2.getRank())) {
                    return new Pair(card1, card2);
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

    public static Triple hasTriple(List<Card> cards) {
        Pair pair = hasPair(cards);
        if (pair == null)
            return null;
        ArrayList<Card> cloned = new ArrayList<>(cards);
        cloned.remove(pair.card1);
        cloned.remove(pair.card2);
        Card card = containRank(pair.card1.getRank(), cloned);
        if (card != null) {
            return new Triple(pair.card1, pair.card2, card);
        }
        return null;
    }



    public static Street hasStreet(List<Card> cards) {
        List<Card> streetCards = new ArrayList<>();
        List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.sort(cards, ascRankComparator);
        for (int i = 0; i < cards.size(); i++) { //loop each card as start
            streetCards.clear();
            Card firstCard = cards.get(i);
            streetCards.add(firstCard);
            int rankIndexOfNextCard = firstCard.getRank().getValue() - 1;
            for (int j = 0; j < cards.size(); j++) {
                Card card = cards.get(j);
                if (rankIndexOfNextCard <= ranks.size()-1) {
                    if (card.getRank().equals(ranks.get(rankIndexOfNextCard))) {
                        rankIndexOfNextCard++;
                        streetCards.add(card);
                    }
                    if (streetCards.size() == 5) {
                        return new Street(streetCards);
                    }
                }
            }
        }

        //check minor street.
        Card aceCard = cards.get(cards.size() - 1);
        streetCards.clear();
        if (aceCard.getRank() == Rank.ACE) {
            streetCards.add(cards.get(cards.size()-1));
            int value = Rank.TWO.getValue();
            for (int i = 0; i < 4; i++) {
                Card card1 = cards.get(i);
                if (card1.getRank().getValue() == value) {
                    streetCards.add(card1);
                    value++;
                } else
                    return null;
            }
            return new Street(streetCards);
        }
        return null;
    }


    public static Flush hasFlush(List<Card> cards) {
        int start = 0;
        int end = 5;
        List<Card> chervi = new ArrayList<>();
        List<Card> bubi = new ArrayList<>();
        List<Card> piki = new ArrayList<>();
        List<Card> kresti = new ArrayList<>();
        for (Card card : cards) {
            switch (card.getMast()) {
                case CHERVI: chervi.add(card);break;
                case BUBI: bubi.add(card);break;
                case PIKI: piki.add(card);break;
                case KRESTI: kresti.add(card);break;
            }
        }
        if (chervi.size() >= 5) {
            Collections.sort(chervi,new RankComparator(false));
            return new Flush(chervi.subList(start,end));
        }
        if (bubi.size() >=5) {
            Collections.sort(bubi,new RankComparator(false));
            return new Flush(bubi.subList(start,end));
        }
        if (kresti.size() >=5) {
            Collections.sort(kresti,new RankComparator(false));
            return new Flush(kresti.subList(start,end));
        }
        if (piki.size() >=5) {
            Collections.sort(piki,new RankComparator(false));
            return new Flush(piki.subList(start,end));
        }
        return null;
    }

    public static FullHouse hasFullHouse(List<Card> cardLis) {
        List<Card> c = new ArrayList<>(cardLis);
        Pair pair = hasPair(c);
        if (pair == null)
            return null;
        c.removeAll(pair.getCards());
        Triple triple = hasTriple(c);
        if (triple != null)
            return new FullHouse(pair, triple);
        return null;

    }

    public static Kare hasKare(List<Card> cards) {
        Triple triple = hasTriple(cards);
        if (triple != null) {
            ArrayList<Card> temp = new ArrayList<Card>(cards);
            temp.removeAll(triple.getList());
            Card fourthCard = containRank(triple.card1.getRank(), temp);
            if (fourthCard != null) {
                ArrayList<Card> kareList = new ArrayList<Card>(triple.getList());
                kareList.add(fourthCard);
                return new Kare(kareList);
            }
        }
        return null;
    }

    public static StreetFlush hasStreetFlush(List<Card> cards) {
        Street street = hasStreet(cards);
        if (street != null) {
            List<Card> streetCards = street.getCards();
            Mast streetMast = streetCards.get(0).getMast();
            for (Card card : street.getCards()) {
                if (!streetMast.equals(card.getMast()))
                    return null;
            }
            return new StreetFlush(streetCards);
        }
        return null;

    }

    public static RoyalFlush hasRoyalFlush(List<Card> cardLis) {
        StreetFlush streetFlush = hasStreetFlush(cardLis);
        if (streetFlush != null) {
            List<Card> streetFlushCards = streetFlush.getCards();
            Collections.sort(streetFlushCards,descRankComparator);
            if (streetFlushCards.get(0).getRank() == Rank.ACE)
                return new RoyalFlush(streetFlushCards);
        }

        return null;
    }


    private static Card containRank(Rank rank, List<Card> cards) {
        for (Card card : cards) {
            if (card.getRank().equals(rank))
                return card;
        }
        return null;
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

    public static void doMagic(List<Hand> hands, List<Card> flop ) {
        final ArrayList<Card> deck = initializeDeck();
        for (Hand hand : hands) {
            deck.removeAll(hand.getCards());
        }
        deck.removeAll(flop);
        List<HandCardSet> allCombs = new ArrayList<>();
        for (Card card : deck) {
            CombinationsForOneCard combinationsForOneCard = new CombinationsForOneCard();
            for (Hand hand : hands) {
                ArrayList<Card> cardSet = new ArrayList<>(hand.getCards());
                cardSet.addAll(flop);
                cardSet.add(card);
                Pair pair = CombinationHelper.hasPair(cardSet);
                TwoPairs twoPairs = CombinationHelper.hasTwoPairs(cardSet);
                Triple triple = CombinationHelper.hasTriple(cardSet);
                Street street = CombinationHelper.hasStreet(cardSet);
                Flush flush = CombinationHelper.hasFlush(cardSet);
                FullHouse fullHouse = CombinationHelper.hasFullHouse(cardSet);
                Kare kare = CombinationHelper.hasKare(cardSet);
                StreetFlush streetFlush = CombinationHelper.hasStreetFlush(cardSet);
                RoyalFlush royalFlush = CombinationHelper.hasRoyalFlush(cardSet);

                if (pair != null)
                    combinationsForOneCard.addPair(new HandCardSet<Pair>(hand, pair));
                if (twoPairs != null)
                    combinationsForOneCard.addTwoPair(new HandCardSet<TwoPairs>(hand, twoPairs));
                if (triple != null)
                    combinationsForOneCard.addTriple(new HandCardSet<Triple>(hand, triple));
                if (street != null)
                    combinationsForOneCard.addStreet(new HandCardSet<Street>(hand, street));
                if (flush != null)
                    combinationsForOneCard.addFlush(new HandCardSet<Flush>(hand, flush));
                if (fullHouse != null)
                    combinationsForOneCard.addFullHouse(new HandCardSet<FullHouse>(hand, fullHouse));
                if (kare != null)
                    combinationsForOneCard.addKare(new HandCardSet<Kare>(hand, kare));
                if (streetFlush != null)
                    combinationsForOneCard.addStreetFlush(new HandCardSet<StreetFlush>(hand, streetFlush));
                if (royalFlush != null)
                    combinationsForOneCard.addRoyalFlush(new HandCardSet<RoyalFlush>(hand, royalFlush));
            }
            allCombs.add(combinationsForOneCard.getOnlyBestWinnerCombination());
        }
    }
}
