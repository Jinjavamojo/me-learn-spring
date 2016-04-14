package pk.view;

import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class CardChooser extends JFrame{

    private CardCoordinate cardCoordinate;
    public CardChooser() {
        try {
            BufferedImage bigImg = ImageIO.read(new File("resources/aDeck2.png"));
            final int width = 144;
            int spaceW = 14;
            final int height = 212;
            final int rows = 4;
            final int cols = 13;
            BufferedImage[][] sprites = new BufferedImage[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (j == cols - 1 || i == rows - 1) {
                        spaceW = 0;
                    } else {
                        spaceW = 14;
                    }
                    sprites[i][j] = bigImg.getSubimage(
                            j * width + (j * spaceW),
                            i * height + (i * spaceW),
                            width,
                            height
                    );
                }
            }
            JPanel panel = new JPanel();
            panel.setLayout(new MigLayout());
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    ImageIcon imageIcon = new ImageIcon(sprites[i][j]);
                    Image img = imageIcon.getImage();
                    Image newimg = img.getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING);
                    ImageIcon total = new ImageIcon(newimg);
                    final CardImageButton imageButton = new CardImageButton(i, j, total);
                    imageButton.setSize(new Dimension(50,100));
                    imageButton.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            cardCoordinate = imageButton.getCardCoordinate();
                            CardChooser.this.dispose();
                        }
                    });
                    if (j == cols - 1) {
                        panel.add(imageButton, "wrap");
                    } else {
                        panel.add(imageButton);
                    }
                }
            }
            setContentPane(panel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CardCoordinate getCardCoordinate() {
        return cardCoordinate;
    }
}
