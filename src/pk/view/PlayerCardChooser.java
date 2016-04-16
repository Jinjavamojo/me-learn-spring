package pk.view;

import net.miginfocom.swing.MigLayout;
import pk.model.Card;
import pk.model.CardCoordinate;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;


public class PlayerCardChooser extends JPanel {

    private CardPlace cardPlace;
    private CardPlace cardPlace2;
    private JList<String> availableCombs;

    public PlayerCardChooser(int number) {
        cardPlace = new CardPlace();
        cardPlace2 = new CardPlace();
        availableCombs = new JList<>();
        availableCombs.setPreferredSize(new Dimension(100,100));
        setLayout(new MigLayout());
        add(new JLabel("hand " + number), "wrap");
        add(cardPlace);
        add(cardPlace2, "wrap");
        add(availableCombs);
    }

    public java.util.List<Card> getCards() {
        List<Card> cards = new ArrayList<>();
        cards.add(cardPlace.getCard());
        cards.add(cardPlace2.getCard());
        return cards;
    }
}
