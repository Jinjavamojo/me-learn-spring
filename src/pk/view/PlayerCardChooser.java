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

    private int number;
    private CardPlace cardPlace;
    private CardPlace cardPlace2;
    private JList<String> availableCombs;

    public PlayerCardChooser(int number) {
        Dimension dimension = new Dimension(200, 250);
        this.number = number;
        cardPlace = new CardPlace();
        cardPlace2 = new CardPlace();
        availableCombs = new JList<>();
        availableCombs.setModel(new DefaultListModel<String>());
        availableCombs.setMinimumSize(dimension);
        //scrollPane.setViewportView(availableCombs);
        setLayout(new MigLayout());
        add(new JLabel("hand " + number), "wrap");
        add(cardPlace);
        add(cardPlace2, "wrap");
        JScrollPane scrollPane = new JScrollPane(availableCombs);
        scrollPane.setMinimumSize(dimension);

        add(scrollPane);
    }

    public java.util.List<Card> getCards() {
        List<Card> cards = new ArrayList<>();
        cards.add(cardPlace.getCard());
        cards.add(cardPlace2.getCard());
        return cards;
    }

    public int getNumber() {
        return number;
    }

    public void clearList() {
        DefaultListModel<String> model = (DefaultListModel<String>)availableCombs.getModel();
        model.removeAllElements();
    }

    public void addElementToList(String s) {
        DefaultListModel<String> model = (DefaultListModel<String>)availableCombs.getModel();
        model.addElement(s);
    }
}
