package pk.combinations;

import pk.model.Card;

import java.util.ArrayList;
import java.util.List;


public class Street extends CardSet<Street> {

    boolean isMinor = false;

    public Street(List<Card> cards, boolean isMinor) {
        this.cards = new ArrayList<>();
        this.cards.addAll(cards);
        this.isMinor = isMinor;
    }

    @Override
    public int compareTo(Street o) {
        if (this.isMinor && o.isMinor)
            return 0;
        if (this.isMinor)
            return -1;
        if (o.isMinor)
            return 1;
        for (Card card : this.cards) {
            for (Card otherCard : o.getCards()) {
                if (card.getRank().getValue() > otherCard.getRank().getValue()) {
                    return 1;
                }
                if (card.getRank().getValue() < otherCard.getRank().getValue()) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public boolean isMinor() {
        return isMinor;
    }

    public void setMinor(boolean isMinor) {
        this.isMinor = isMinor;
    }
}
