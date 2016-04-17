package pk.combinations;


public class FullHouse extends CardSet<FullHouse> {

    Triple triple;
    Pair pair;

    public FullHouse(Pair pair, Triple triple) {
        this.pair = pair;
        this.triple = triple;
    }

    @Override
    public int compareTo(FullHouse o) {
        return 0;
    }
}
