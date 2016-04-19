package pk;

import com.sun.istack.internal.Nullable;
import pk.combinations.*;
import pk.comparators.DeckComparator;
import pk.comparators.RankComparator;
import pk.model.*;

import java.util.*;


public class CombinationHelper {

    public static Comparator<Card> ascRankComparator = new RankComparator(true);
    public static Comparator<Card> descRankComparator = new RankComparator(false);

    public static Pair hasPair(@Nullable List<Card> playerCards, List<Card> turn, boolean canFindPairInTurn) {
        if (playerCards != null) {
            Collections.sort(playerCards,descRankComparator);
            for (Card playerCard : playerCards) {
                for (Card card : turn) {
                    if (playerCard.getRank().getValue() == card.getRank().getValue())
                        return new Pair(playerCard, card);
                }
            }
        }
        if (canFindPairInTurn) {
            for (int i = 0; i < turn.size(); i++) {
                Card card1 = turn.get(i);
                for (int j = i + 1; j < turn.size(); j++) {
                    Card card2 = turn.get(j);
                    if (card1.getRank().equals(card2.getRank())) {
                        return new Pair(card1, card2);
                    }
                }
            }
        }
        return null;
    }

    public static TwoPairs hasTwoPairs(List<Card> playerCards, List<Card> turn) {
        Pair pair = hasPair(playerCards,turn, true);
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

    //can be 1 + 2
    //can be 2 + 1
    //can be 0 + 3 - need only by full house
    public static Triple hasTriple(List<Card> playerCards, List<Card> turn, boolean canFindTripleInTurn) {
        Rank rank = playerCards.get(0).getRank();
        List<Card> result = new ArrayList<>();
        result.add(playerCards.get(0));
        if (rank.getValue() == playerCards.get(1).getRank().getValue()) {
            //then we have pair and find third card in turn
            result.add(playerCards.get(1));
            for (Card card : turn) {
                if (card.getRank().getValue() == rank.getValue()) {
                    result.add(card);
                    return new Triple(result);
                }
            }
        } else {
            //then find two cards with same rank
            for (Card card : turn) {
                if (card.getRank().getValue() == rank.getValue()) {
                    result.add(card);
                }
            }
            if (result.size() == 3)
                return new Triple(result);
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


    //can be care at turn (4 of 5)
    //can be care at player cards + turn.  (1+3 or 2+2)
    // We accept only player cards + turn cards
    public static Kare hasKare(List<Card> playerCards, List<Card> turn) {

        //1. player have pair + 2 cards on turn.
        List<Card> kare = new ArrayList<>();
        Card playerCard = playerCards.get(0);
        kare.add(playerCard);
        for (Card card : turn) {
            if (playerCard.getRank().getValue() == card.getRank().getValue())
                kare.add(card);
        }
        if (kare.size() == 4)
            return new Kare(kare);
        kare.clear();
        playerCard = playerCards.get(1);
        for (Card card : turn) {
            if (playerCard.getRank().getValue() == card.getRank().getValue())
                kare.add(card);
        }
        if (kare.size() == 4)
            return new Kare(kare);

        //2. player have 1 card + 3 card on turn.
        kare.clear();
        if (playerCards.get(0).getRank().getValue() == playerCards.get(1).getRank().getValue()) {
            kare.add(playerCards.get(0));
            kare.add(playerCards.get(1));
            for (Card card: turn) {
                if (playerCard.getRank().getValue() == card.getRank().getValue())
                    kare.add(card);
            }
        }
        if (kare.size() == 4)
            return new Kare(kare);
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
            if (streetFlushCards.get(0).getRank() == Rank.ACE && streetFlushCards.get(1).getRank() == Rank.KING)
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
                flop.add(card);
                Pair pair = CombinationHelper.hasPair(hand.getCards(),flop);
                TwoPairs twoPairs = CombinationHelper.hasTwoPairs(cardSet);
                Triple triple = CombinationHelper.hasTriple(cardSet);
                Street street = CombinationHelper.hasStreet(cardSet);
                Flush flush = CombinationHelper.hasFlush(cardSet);
                FullHouse fullHouse = CombinationHelper.hasFullHouse(cardSet);
                Kare kare = CombinationHelper.hasKare(hand.getCards(),flop);
                StreetFlush streetFlush = CombinationHelper.hasStreetFlush(cardSet);
                RoyalFlush royalFlush = CombinationHelper.hasRoyalFlush(cardSet);
                flop.remove(card);

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
            allCombs.addAll(combinationsForOneCard.getOnlyBestWinnerCombination());
        }
        int g = 0;
    }
}
