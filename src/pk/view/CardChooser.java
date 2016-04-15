package pk.view;

import net.miginfocom.swing.MigLayout;
import pk.model.Card;
import pk.model.CardCoordinate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;


public class CardChooser extends JFrame{

    private CardCoordinate cardCoordinate;
    public CardChooser() {
            JPanel panel = new JPanel();
            panel.setLayout(new MigLayout());
            for (int i = 0; i < SingleWindow.rows; i++) {
                for (int j = 0; j < SingleWindow.cols; j++) {
                    ImageIcon imageIcon = new ImageIcon(SingleWindow.sprites[i][j]);
                    Image img = imageIcon.getImage();
                    Image newimg = img.getScaledInstance(50, 75, Image.SCALE_AREA_AVERAGING);
                    ImageIcon total = new ImageIcon(newimg);
                    final CardImageButton imageButton = new CardImageButton(i, j, total);
                    imageButton.setPreferredSize(new Dimension(25, 25));
                    if (SingleWindow.alreadyChoosenCards.get(new CardCoordinate(i,j)) != null) {
                        imageButton.setEnabled(false);
                    }
                    imageButton.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            cardCoordinate = imageButton.getCardCoordinate();
                            CardChooser.this.dispose();
                        }
                    });
                    if (j == SingleWindow.cols - 1) {
                        panel.add(imageButton, "wrap");
                    } else {
                        panel.add(imageButton);
                    }
                }
            }
            setContentPane(panel);
    }

    public CardCoordinate getCardCoordinate() {
        return cardCoordinate;
    }
}
