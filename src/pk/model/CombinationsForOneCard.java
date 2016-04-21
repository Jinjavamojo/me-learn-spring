package pk.model;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import pk.combinations.*;
import pk.comparators.PairComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
public class CombinationsForOneCard {

    private HandCardSet<RoyalFlush> royalFlush; //available only one, but list is more softer
    private List<HandCardSet<StreetFlush>> streetFlushes;
    private List<HandCardSet<Kare>> kares;
    private List<HandCardSet<FullHouse>> fullHouses;
    private List<HandCardSet<Flush>> flushes;
    private List<HandCardSet<Street>> streets;
    private List<HandCardSet<Triple>> triples;
    private List<HandCardSet<TwoPairs>> twoPairs;
    private List<HandCardSet<Pair>> pairs;

    private static PairComparator<HandCardSet<Pair>> pairComparator;

    static {
        pairComparator = new PairComparator<>();
    }

    public CombinationsForOneCard() {
        pairs = new ArrayList<>();
        twoPairs = new ArrayList<>();
        triples = new ArrayList<>();
        streets = new ArrayList<>();
        flushes = new ArrayList<>();
        fullHouses = new ArrayList<>();
        kares = new ArrayList<>();
        streetFlushes = new ArrayList<>();
    }



    public void addRoyalFlush(HandCardSet<RoyalFlush> royalFlush) {
        this.royalFlush = royalFlush;
    }

    public void  addStreetFlush(HandCardSet<StreetFlush> streetFlush) {
        streetFlushes.add(streetFlush);
    }

    public void addKare(HandCardSet<Kare> kare) {
        kares.add(kare);
    }

    public void addFullHouse(HandCardSet<FullHouse> fullHouse) {
        this.fullHouses.add(fullHouse);
    }

    public void addFlush(HandCardSet<Flush> flush) {
        this.flushes.add(flush);
    }

    public void  addStreet(HandCardSet<Street> street) {
        streets.add(street);
    }

    public void addTriple(HandCardSet<Triple> triple) {
        this.triples.add(triple);
    }

    public void  addTwoPair(HandCardSet<TwoPairs> twoPairs) {
        this.twoPairs.add(twoPairs);
    }
    public void  addPair(HandCardSet<Pair> pair) {
        pairs.add(pair);
    }

    public List<HandCardSet<StreetFlush>> getStreetFlushes() {
        return streetFlushes;
    }

    public List<HandCardSet<Kare>> getKares() {
        return kares;
    }

    public List<HandCardSet<FullHouse>> getFullHouses() {
        return fullHouses;
    }

    public List<HandCardSet<Flush>> getFlushes() {
        return flushes;
    }

    public List<HandCardSet<Street>> getStreets() {
        return streets;
    }

    public List<HandCardSet<Triple>> getTriples() {
        return triples;
    }

    public List<HandCardSet<TwoPairs>> getTwoPairs() {
        return twoPairs;
    }

    public List<HandCardSet<Pair>> getPairs() {
        return pairs;
    }

    public Collection<HandCardSet> getOnlyBestWinnerCombination() {
        Collection<HandCardSet> bestHandCardSets = new ArrayList<>();
        if (royalFlush != null) {
            bestHandCardSets.add(royalFlush);
            return bestHandCardSets;
        }

        if (!CollectionUtils.isEmpty(streetFlushes)) {
            bestHandCardSets.addAll(getBestFromOneTypeCombinations(streetFlushes));
            return bestHandCardSets ;
        }

        if (!CollectionUtils.isEmpty(kares)) {
            bestHandCardSets.addAll(getBestFromOneTypeCombinations(kares));
            return bestHandCardSets;
        }

        if (!CollectionUtils.isEmpty(fullHouses)) {
            bestHandCardSets.addAll(getBestFromOneTypeCombinations(fullHouses));
            return bestHandCardSets;
        }

        if (!CollectionUtils.isEmpty(flushes)) {
            bestHandCardSets.addAll(getBestFromOneTypeCombinations(flushes));
            return bestHandCardSets;
        }
        if (!CollectionUtils.isEmpty(streets)) {
            bestHandCardSets.addAll(getBestFromOneTypeCombinations(streets));
            return bestHandCardSets;
        }

        if (!CollectionUtils.isEmpty(triples)) {
            bestHandCardSets.addAll(getBestFromOneTypeCombinations(triples));
            return bestHandCardSets;
        }
        if (!CollectionUtils.isEmpty(pairs)) {
            bestHandCardSets.addAll(getBestFromOneTypeCombinations(pairs));
            return bestHandCardSets;
        }
        return null;

    }

    public List<HandCardSet> getBestFromOneTypeCombinations(List cardSets) {
        List<HandCardSet> bestCardSets = new ArrayList<>();
        HandCardSet resultTriplet = (HandCardSet)cardSets.get(0);
        for (Object o : cardSets) {
            HandCardSet o1 = (HandCardSet)o;
            if (o1 != resultTriplet) {
                int i = resultTriplet.getSomeCombination().compareTo(o1.getSomeCombination());
                if (i == -1) {
                    resultTriplet = o1;
                }
                if (i == 0 && resultTriplet.getSomeCombination() != o1.getSomeCombination()) {
                    bestCardSets.add(o1);
                }
            }
        }
        bestCardSets.add(resultTriplet);
        return bestCardSets;
    }
}
