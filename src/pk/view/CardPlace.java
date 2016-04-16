package pk.view;

import net.miginfocom.swing.MigLayout;
import pk.model.Card;
import pk.model.CardCoordinate;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.Map;


public class CardPlace extends JPanel {

    private JButton chooser;
    private Card card;
    private CardCoordinate cardCoordinate;

    public CardPlace() {
        ImageIcon imageIcon =  new ImageIcon();
        ImageIcon back = new ImageIcon("resources/back.png");
        Image newimg = back.getImage().getScaledInstance(50, 75, Image.SCALE_AREA_AVERAGING);
        imageIcon.setImage(newimg);
        chooser = new JButton("pick");
        chooser.setMaximumSize(new Dimension(35, 25));
        chooser.setForeground(new Color(255, 180, 34));
        chooser.setBorder(new LineBorder(new Color(255,180,34)));
        chooser.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                final CardChooser cardChooser = new CardChooser();
                cardChooser.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        if (cardChooser.getCardCoordinate() != null) {
                            if (cardCoordinate != null) {
                                SingleWindow.alreadyChoosenCards.remove(cardCoordinate);
                            }
                        }
                        cardCoordinate = cardChooser.getCardCoordinate();
                        Image newimg = SingleWindow.sprites[cardCoordinate.getRow()][cardCoordinate.getCol()].getScaledInstance(50, 75, Image.SCALE_AREA_AVERAGING);
                        ImageIcon icon = new ImageIcon(newimg);
                        card = SingleWindow.deckMap.get(cardCoordinate).clone();
                        SingleWindow.alreadyChoosenCards.remove(cardCoordinate);
                        SingleWindow.alreadyChoosenCards.put(cardCoordinate,card);
                        CardPlace.this.removeAll();
                        JLabel imageDisplayer = new JLabel(icon);
                        CardPlace.this.add(imageDisplayer);
                        CardPlace.this.add(chooser,"wrap");
                        CardPlace.this.updateUI();
                    }
                });
                final JDialog frame = new JDialog(cardChooser, "Choose card", true);
                frame.setContentPane(cardChooser.getContentPane());
                frame.pack();
                frame.setVisible(true);

            }
        });
        setLayout(new MigLayout());
        add(new JLabel(imageIcon));
        add(chooser, "wrap");
    }

    public Card getCard() {
        return card;
    }
}
