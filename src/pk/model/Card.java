package pk.model;

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
        return mast.getValue() + rank.getValue();
    }

    @Override
    public String toString() {
        return rank.toString() + " " + mast.toString() + "/" + (rank.getValue() + mast.getValue());
    }

    @Override
    public Card clone()  {
        try {
            return new Card(rank,mast);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
