package pk.combinations;


public class FullHouse extends CardSet {

    Triple triple;
    Pair pair;

    public FullHouse(Pair pair, Triple triple) {
        this.pair = pair;
        this.triple = triple;
    }
}
