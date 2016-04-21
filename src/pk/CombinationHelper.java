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
            if (playerCards.get(0).getRank() == playerCards.get(1).getRank())
                return new Pair(playerCards.get(0),playerCards.get(1));
            Collections.sort(playerCards,descRankComparator);
            for (Card playerCard : playerCards) {
                for (Card card : turn) {
                    if (playerCard.getRank().getValue() == card.getRank().getValue())
                        return new Pair(playerCard, card);
                }
            }
        }
        if (canFindPairInTurn) {
            return findPairInTurn(turn);
        }
        return null;
    }

    private static Pair findPairInTurn(List<Card> turn) {
        for (int i = 0; i < turn.size(); i++) {
            Card card1 = turn.get(i);
            for (int j = i + 1; j < turn.size(); j++) {
                Card card2 = turn.get(j);
                if (card1.getRank().equals(card2.getRank())) {
                    return new Pair(card1, card2);
                }
            }
        }
        return null;

    }

    //can be 1+1 and 1+1
    //can be 2 + 2
    //can be 1+1 and 2
    public static TwoPairs hasTwoPairs(List<Card> playerCards, List<Card> turn) {
        Collections.sort(turn, descRankComparator);
        Rank rank = playerCards.get(0).getRank();
        if (rank.getValue() == playerCards.get(1).getRank().getValue()) {
            //then 2+2 and we find second pair in turn.
            Pair pairInTurn = findPairInTurn(turn);
            if (pairInTurn != null)
                return new TwoPairs(new Pair(playerCards.get(0),playerCards.get(1)),pairInTurn);
        } else {
            //then 1+1 and 1+1 we find
            Pair one = null;
            Pair two = null;
            for (Card card : turn) {
                if (playerCards.get(0).getRank().getValue() == card.getRank().getValue()) {
                    one = new Pair(playerCards.get(0),card);
                }
                if (playerCards.get(1).getRank().getValue() == card.getRank().getValue()) {
                    two = new Pair(playerCards.get(1),card);
                }
            }
            if (one != null && two != null) {
                return new TwoPairs(one, two);
            }
        }

        //can be 1+1 and 2
        Pair pair = null;
        for (Card turnCard : turn) {
            if (playerCards.get(0).getRank().getValue() == turnCard.getRank().getValue()) {
                pair = new Pair(playerCards.get(0),turnCard);
            }
            if (playerCards.get(1).getRank().getValue() == turnCard.getRank().getValue()) {
                pair = new Pair(playerCards.get(1),turnCard);
            }
        }
        //we find second pair in turn
        if (pair != null) {
            Pair pairInTurn = findPairInTurn(turn);
            if (pairInTurn != null) {
                return new TwoPairs(pair, pairInTurn);
            }
        }

        return null;
    }

    //can be 1 + 2
    //can be 2 + 1
    //can be 0 + 3 - need only by full house
    public static Triple hasTriple(List<Card> playerCards, List<Card> turn) {
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



    public static Street hasStreet(List<Card> playerCards, List<Card> river) {
        Street street = null;
        List<Card> allCards = new ArrayList<>(playerCards);
        allCards.addAll(river);
        List<Card> streetCards = new ArrayList<>();
        List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.sort(allCards, ascRankComparator);
        for (int i = 0; i < allCards.size() && street == null; i++) { //loop each card as start
            streetCards.clear();
            Card firstCard = allCards.get(i);
            streetCards.add(firstCard);
            int rankIndexOfNextCard = firstCard.getRank().getValue() - 1;
            for (int j = 0; j < allCards.size() && street == null; j++) {
                Card card = allCards.get(j);
                if (rankIndexOfNextCard <= ranks.size()-1) {
                    if (card.getRank().equals(ranks.get(rankIndexOfNextCard))) {
                        rankIndexOfNextCard++;
                        streetCards.add(card);
                    }
                    if (streetCards.size() == 5) {
                        street = new Street(streetCards);
                    }
                }
            }
        }

        if (street == null) {
            //check minor street.
            Card aceCard = allCards.get(allCards.size() - 1);
            streetCards.clear();
            if (aceCard.getRank() == Rank.ACE) {
                streetCards.add(allCards.get(allCards.size()-1));
                int value = Rank.TWO.getValue();
                for (int i = 0; i < 4; i++) {
                    Card card1 = allCards.get(i);
                    if (card1.getRank().getValue() == value) {
                        streetCards.add(card1);
                        value++;
                    } else
                        return null;
                }
                street = new Street(streetCards);
            }
        }
        //check is street contains not only river cards
        if (street != null && isAllCardExisted(streetCards, river,5)) {
            return null;
        }
        return street;
    }

    private static boolean isAllCardExisted(List<Card> cards, List<Card> river, int howMathEqualsNeed){
        int i = 0;
        for (Card streetCard : cards) {
            for (Card card : river) {
                if (streetCard.equals(card))
                    i++;
            }
        }
        if (i == howMathEqualsNeed) {
            return true;
        }
        return false;
    }


    public static Flush hasFlush(List<Card> cards, List<Card> river) {
        Flush flush= null;
        int start = 0;
        int end = 5;
        List<Card> allCards = new ArrayList<>(cards);
        allCards.addAll(river);
        List<Card> chervi = new ArrayList<>();
        List<Card> bubi = new ArrayList<>();
        List<Card> piki = new ArrayList<>();
        List<Card> kresti = new ArrayList<>();
        for (Card card : allCards) {
            switch (card.getMast()) {
                case CHERVI: chervi.add(card);break;
                case BUBI: bubi.add(card);break;
                case PIKI: piki.add(card);break;
                case KRESTI: kresti.add(card);break;
            }
        }
        if (chervi.size() >= 5) {
            Collections.sort(chervi,new RankComparator(false));
            flush=  new Flush(chervi.subList(start,end));
        }
        if (bubi.size() >=5) {
            Collections.sort(bubi,new RankComparator(false));
            flush = new Flush(bubi.subList(start,end));
        }
        if (kresti.size() >=5) {
            Collections.sort(kresti,new RankComparator(false));
            flush = new Flush(kresti.subList(start,end));
        }
        if (piki.size() >=5) {
            Collections.sort(piki,new RankComparator(false));
            flush = new Flush(piki.subList(start,end));
        }
        //check is street contains not only river cards
        if (flush != null && isAllCardExisted(cards, river,5)) {
            return null;
        }
        return flush;
    }


    //can be pair in hand and triple in turn
    //can be 1+1 pair, 1+2 triple
    //can be 2+1 triple + pair in turn
    public static FullHouse hasFullHouse(List<Card> playerCards, List<Card> turn) {
        if (playerCards.get(0).getRank().getValue() == playerCards.get(1).getRank().getValue()) {
            //we have pair. then find or 1 card for triple or 3 to triple
            Triple triple = null;
            for (Card card : turn) {
                if (card.getRank().getValue() == playerCards.get(0).getRank().getValue()) {
                    List<Card> tripleCards = new ArrayList<>(playerCards);
                    tripleCards.add(card);
                    triple = new Triple(tripleCards);
                }
            }
            if (triple != null)
                return new FullHouse(new Pair(playerCards.get(0),playerCards.get(1)),triple);
        } else {
            //we find 1 card to pair of first player card. and 2 card to triplet of second player card or
            List<Card> l1 = new ArrayList<>();
            List<Card> l2 = new ArrayList<>();
            l1.add(playerCards.get(0));
            l2.add(playerCards.get(1));
            for (Card card : turn) {
                if (playerCards.get(0).getRank().getValue() == card.getRank().getValue()) {
                    l1.add(card);
                }
                if (playerCards.get(1).getRank().getValue() == card.getRank().getValue()) {
                    l2.add(card);
                }
            }
            if (l1.size() == 2 && l2.size() == 3) {
                return new FullHouse(new Pair(l1.get(0),l1.get(1)),new Triple(l2));
            }
            if (l1.size() == 3 && l2.size() == 2) {
                return new FullHouse(new Pair(l2.get(0),l2.get(1)),new Triple(l1));
            }
        }
        return null;
    }


    //can be care at turn (4 of 5)
    //can be care at player cards + turn.  (1+3 or 2+2)
    // We accept only player cards + turn cards
    public static Kare hasKare(List<Card> playerCards, List<Card> turn) {

        Kare kare = null;
        //1. player have pair + 2 cards on turn.
        List<Card> kareCards = new ArrayList<>();
        Card playerCard = playerCards.get(0);
        kareCards.add(playerCard);
        for (Card card : turn) {
            if (playerCard.getRank().getValue() == card.getRank().getValue())
                kareCards.add(card);
        }
        if (kareCards.size() == 4)
            kare =  new Kare(kareCards);

        //lets finding by second card
        if (kare == null) {
            kareCards.clear();
            playerCard = playerCards.get(1);
            for (Card card : turn) {
                if (playerCard.getRank().getValue() == card.getRank().getValue())
                    kareCards.add(card);
            }
            if (kareCards.size() == 4)
                kare =  new Kare(kareCards);
            if (kare == null) {
                //2. player have 1 card + 3 card on turn.
                kareCards.clear();
                if (playerCards.get(0).getRank().getValue() == playerCards.get(1).getRank().getValue()) {
                    kareCards.add(playerCards.get(0));
                    kareCards.add(playerCards.get(1));
                    for (Card card: turn) {
                        if (playerCard.getRank().getValue() == card.getRank().getValue())
                            kareCards.add(card);
                    }
                }
            }
        }

        if (kareCards.size() == 4 || kare != null) {
            if (isAllCardExisted(kareCards,turn,4))
                return null;
            return new Kare(kareCards);
        }
        return kare;
    }

    public static StreetFlush hasStreetFlush(List<Card> playerCards, List<Card> turn) {
        Street street = hasStreet(playerCards, turn);
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

    public static RoyalFlush hasRoyalFlush(List<Card> playerCards, List<Card> turn) {
        StreetFlush streetFlush = hasStreetFlush(playerCards, turn);
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
                Pair pair = CombinationHelper.hasPair(hand.getCards(),flop, false);
                TwoPairs twoPairs = CombinationHelper.hasTwoPairs(hand.getCards(), flop);
                Triple triple = CombinationHelper.hasTriple(hand.getCards(),flop);
                Street street = CombinationHelper.hasStreet(hand.getCards(),flop);
                Flush flush = CombinationHelper.hasFlush(hand.getCards(),flop);
                FullHouse fullHouse = CombinationHelper.hasFullHouse(hand.getCards(),flop);
                Kare kare = CombinationHelper.hasKare(hand.getCards(),flop);
                StreetFlush streetFlush = CombinationHelper.hasStreetFlush(hand.getCards(),flop);
                RoyalFlush royalFlush = CombinationHelper.hasRoyalFlush(hand.getCards(),flop);
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
