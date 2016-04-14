package pk.view;

import javax.swing.*;

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
