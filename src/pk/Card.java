package pk;

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
public class Card {

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
        return rank.toString() + " " + mast.toString();
    }
}
