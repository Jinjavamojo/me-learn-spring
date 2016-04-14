package pk.view;

import net.miginfocom.swing.MigLayout;
import pk.model.Mast;
import pk.model.Rank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

/**
 * Created by Денис on 11.04.2016.
 */
public class SingleWindow extends JFrame {

    public SingleWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        //MigLayout migLayout = new MigLayout();

        JPanel jPanel = new JPanel(new MigLayout());
        jPanel.add(createList(),"span 1 2");
        JComboBox mustCombobox = createComboBox(Arrays.asList(Mast.values()));
        JButton addMast = createButton(new Dimension(50,25), "add mast");
        addMast.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                final CardChooser cardChooser = new CardChooser();
                cardChooser.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        CardCoordinate cardCoordinate = cardChooser.getCardCoordinate();
                        int g = 0;
                    }
                });
                final JDialog frame = new JDialog(cardChooser, "Choose card", true);
                frame.setContentPane(cardChooser.getContentPane());
                frame.pack();
                frame.setVisible(true);
            }
        });
        jPanel.add(mustCombobox);
        jPanel.add(addMast, "wrap");
        JComboBox chooseRank = createComboBox(Arrays.asList(Rank.values()));
        JButton addRank = createButton(new Dimension(50,25), "add rank");
        jPanel.add(chooseRank);
        jPanel.add(addRank, "wrap");
        contentPane.add(jPanel);
        //contentPane.setLayout(migLayout);
        pack();
        setVisible(true);
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
        objectJComboBox.setSize(new Dimension(200,50));
        for (Object value : values) {
            objectJComboBox.addItem(value);
        }
        return objectJComboBox;
    }
}
