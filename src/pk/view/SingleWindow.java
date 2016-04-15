package pk.view;

import net.miginfocom.swing.MigLayout;
import pk.CombinationHelper;
import pk.model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created by Денис on 11.04.2016.
 */
public class SingleWindow extends JFrame {

    public static BufferedImage[][] sprites;
    public static HashMap<CardCoordinate, Card> alreadyChoosenCards  = new HashMap<>();
    public static HashMap<CardCoordinate,Card> deckMap = new HashMap<>();
    public final static int rows = 4;
    public final static int cols = 13;

    private List<CardPlace> cardPlaces;
    private List<PlayerCardChooser> playerCardChoosers;
    

    public SingleWindow() {
        cardPlaces = new ArrayList<>();
        playerCardChoosers = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        //MigLayout migLayout = new MigLayout();
        initImages();
        initDeck();
        PlayerCardChooser playerCardChooser1= new PlayerCardChooser(1);
        PlayerCardChooser playerCardChooser2= new PlayerCardChooser(2);
        JPanel jPanel = new JPanel(new MigLayout());
        jPanel.add(new JLabel("flop cards"),"wrap");
        for (int i = 0; i < 4; i++) {
            CardPlace cp = new CardPlace();
            cardPlaces.add(cp);
            if (i == 3) {
                jPanel.add(cp,"wrap");
            } else {
                jPanel.add(cp);
            }
        }
        for (int i = 1; i < 3; i ++) {
            PlayerCardChooser choser = new PlayerCardChooser(i);
            playerCardChoosers.add(choser);
            if (i == 2) {
                jPanel.add(choser,"wrap");
            } else {
                jPanel.add(choser);
            }
        }
        JButton button = new JButton("starts!");
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                calculate();
            }
        });
        jPanel.add(button);
        contentPane.add(jPanel);
        pack();
        setVisible(true);
    }
    
    public void initDeck() {
        deckMap = new HashMap<>();
        for (int r = 0; r < rows; r++) {
                Mast mast = null;
                switch (r) {
                    case 0 : mast = Mast.CHERVI;break;
                    case 1 : mast = Mast.BUBI;break;
                    case 2 : mast = Mast.KRESTI;break;
                    case 3 : mast = Mast.PIKI;break;
                }
            deckMap.put(new CardCoordinate(r, 0), new Card(Rank.ACE, mast));
            deckMap.put(new CardCoordinate(r, 1), new Card(Rank.TWO, mast));
            deckMap.put(new CardCoordinate(r, 2), new Card(Rank.THREE, mast));
            deckMap.put(new CardCoordinate(r, 3), new Card(Rank.FOUR, mast));
            deckMap.put(new CardCoordinate(r, 4), new Card(Rank.FIVE, mast));
            deckMap.put(new CardCoordinate(r, 5), new Card(Rank.SIX, mast));
            deckMap.put(new CardCoordinate(r, 6), new Card(Rank.SEVEN, mast));
            deckMap.put(new CardCoordinate(r, 7), new Card(Rank.EIGHT, mast));
            deckMap.put(new CardCoordinate(r, 8), new Card(Rank.NINE, mast));
            deckMap.put(new CardCoordinate(r, 9), new Card(Rank.TEN, mast));
            deckMap.put(new CardCoordinate(r, 10), new Card(Rank.JACK, mast));
            deckMap.put(new CardCoordinate(r, 11), new Card(Rank.QUEEN, mast));
            deckMap.put(new CardCoordinate(r, 12), new Card(Rank.KING, mast));
        }
    }

    public void initImages() {
        try {
            BufferedImage bigImg = ImageIO.read(new File("resources/deck-0.jpg"));
            final int width = 37; //144;
            int spaceH= 7, spaceV = 9;
            final int height = 52;// 212;

            sprites = new BufferedImage[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    sprites[i][j] = bigImg.getSubimage(
                            spaceH + j * width + (j * spaceH),
                            spaceV + i * height + (i * spaceV),
                            width,
                            height
                    );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JList createList() {
        java.util.List<String> values = Arrays.asList("1","2","3","4","1231241241241");
        JList list = new JList(values.toArray());
        list.setSize(new Dimension(200,400));
        list.setLayoutOrientation(JList.VERTICAL);
        return list;
    }

    public JButton createButton(Dimension d, String alias) {
        JButton button = new JButton();
        button.setSize(d);
        button.setText(alias);
        return button;
    }

    public JComboBox createComboBox(List values) {
        JComboBox<Object> objectJComboBox = new JComboBox<>();
        objectJComboBox.setSize(new Dimension(200, 50));
        for (Object value : values) {
            objectJComboBox.addItem(value);
        }
        return objectJComboBox;
    }

    public void calculate() {
        List<Hand> hands = new ArrayList<>();
        for (int i = 0; i < playerCardChoosers.size(); i++) {
            List<Card> cards = playerCardChoosers.get(i).getCards();
            hands.add(new Hand(i,cards.get(0),cards.get(1)));
        }
        List<Card> flop = new ArrayList<>();
        for (int i = 0; i < cardPlaces.size(); i++) {
            flop.add(cardPlaces.get(0).getCard());
        }
        CombinationHelper.doMagic(hands,flop);
    }
}
