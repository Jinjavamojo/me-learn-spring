package pk.combinations;

import org.springframework.util.CollectionUtils;
import pk.model.Card;

import java.util.Collections;
import java.util.List;


public abstract class CardSet<T> implements Comparable<T> {

    protected List<Card> cards;
    boolean isEqualsToSomeElse = false;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        String s = "";
        for (Card card : cards) {
            s+=card.toString() + " ";
        }
        return s;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        if (cards == null)
            return -1;
        for (Card card : cards) {
            hash+=card.hashCode();
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        CardSet<Card> obj1 = (CardSet<Card>) obj;
        if (obj1 == null || this.cards == null)
            return false;
        if (this.cards.size() != obj1.cards.size())
            return false;
        return org.apache.commons.collections4.CollectionUtils.containsAll(this.cards,obj1.getCards());
    }

    public abstract  int compareTo(T t);

    public boolean isEqualsToSomeElse() {
        return isEqualsToSomeElse;
    }

    public void setEqualsToSomeElse(boolean isEqualsToSomeElse) {
        this.isEqualsToSomeElse = isEqualsToSomeElse;
    }
}
