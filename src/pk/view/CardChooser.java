package pk.view;

import net.miginfocom.swing.MigLayout;
import pk.Card;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Денис on 13.04.2016.
 */
public class CardChooser extends JFrame {
    
    public CardChooser() {
        try {
            BufferedImage bigImg = ImageIO.read(new File("resources/aDeck.png"));
            final int width = 144;
            int spaceW = 14;
            final int height = 212;
            final int rows = 4;
            final int cols = 13;
            BufferedImage[][] sprites = new BufferedImage[rows][cols];

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    if (j == cols-1 || i == rows -1) {
                        spaceW = 0;
                    } else {
                        spaceW = 14;
                    }

                    sprites[i][j] = bigImg.getSubimage(
                            j * width + (j*spaceW),
                            i * height + (i*spaceW),
                            width,
                            height
                    );
                }
            }



            BufferedImage image  = null;
            JPanel panel = new JPanel();
            panel.setLayout(new MigLayout());
            for (int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    JButton button = new JButton(new ImageIcon(sprites[i][j]));
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           //CardCoordinate
                        }
                    });
                }

            }
            JButton f = new JButton();
            f.setSize(new Dimension(25,50));
            f.setIcon(new ImageIcon(image));
            setContentPane(panel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
