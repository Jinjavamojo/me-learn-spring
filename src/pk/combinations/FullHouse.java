package pk.combinations;


public class FullHouse extends CardSet<FullHouse> {

    private Triple triple;
    private Pair pair;

    public FullHouse(Pair pair, Triple triple) {
        this.pair = pair;
        this.triple = triple;
    }

    @Override
    public int compareTo(FullHouse o) {
        int i = this.triple.compareTo(o.getTriple());
        if (i != 0) {
            return i;
        }
        return this.pair.compareTo(o.getPair());
    }

    public Triple getTriple() {
        return triple;
    }

    public void setTriple(Triple triple) {
        this.triple = triple;
    }

    public Pair getPair() {
        return pair;
    }

    public void setPair(Pair pair) {
        this.pair = pair;
    }
}
