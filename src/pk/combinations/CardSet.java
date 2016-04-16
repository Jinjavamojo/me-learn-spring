package pk.combinations;

import pk.model.Card;

import java.util.List;


public abstract class CardSet {

    protected List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
