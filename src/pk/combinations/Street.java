package pk.combinations;

import pk.model.Card;

import java.util.ArrayList;
import java.util.List;


public class Street extends CardSet<Street> {

    public Street(List<Card> cards) {
       this.cards = new ArrayList<>();
        this.cards.addAll(cards);
    }

    @Override
    public int compareTo(Street o) {
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


}
