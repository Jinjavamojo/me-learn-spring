package pk;

public class Card implements Cloneable {

    private Rank rank;
    private Mast mast;

    public Card(Rank rank, Mast mast) {
        this.rank = rank;
        this.mast = mast;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Mast getMast() {
        return mast;
    }

    public void setMast(Mast mast) {
        this.mast = mast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (rank != card.rank) return false;
        return mast == card.mast;

    }

    @Override
    public int hashCode() {
        return mast.value + rank.value;
    }

    @Override
    public String toString() {
        return rank.toString() + " " + mast.toString() + "/" + (rank.value + mast.value);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Card(rank,mast);
    }
}
