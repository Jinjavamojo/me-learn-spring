package pk.view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Денис on 11.04.2016.
 */
public class SingleWindow extends JFrame {

    public SingleWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        MigLayout migLayout = new MigLayout();
        contentPane.setLayout(migLayout);
        add(createComboBox());
        add(createComboBox());
        add(createComboBox(),"wrap");
        add(createComboBox());
        pack();
        setVisible(true);

    }

    public JComboBox createComboBox() {
        JComboBox<Object> objectJComboBox = new JComboBox<>();
        objectJComboBox.setSize(new Dimension(200,50));
        objectJComboBox.addItem("ONE");
        objectJComboBox.addItem("TWO");
        return objectJComboBox;
    }
}
