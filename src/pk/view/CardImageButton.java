package pk.view;

import pk.model.CardCoordinate;

import javax.swing.*;


public class CardImageButton extends JButton {

    private CardCoordinate cardCoordinate;

    public CardImageButton(int index1, int index2, ImageIcon imageIcon) {
        super(imageIcon);
        cardCoordinate = new CardCoordinate(index1,index2);
    }

    public CardCoordinate getCardCoordinate() {
        return cardCoordinate;
    }

    public void setCardCoordinate(CardCoordinate cardCoordinate) {
        this.cardCoordinate = cardCoordinate;
    }
}
