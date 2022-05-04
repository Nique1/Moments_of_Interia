package mypack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

public class MainForm extends JFrame{
    private JPanel mainPanel;
    private JPanel picturePanel;
    private JLabel resultLabel;
    private JComboBox comboBox1;
    private JButton calculateButton;
    private JTable table1;

    private Solid[] solids;
    private DefaultTableModel model;

    public MainForm(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent we) {
                frameOpened();
            }
        });
        comboBox1.addActionListener(actionEvent -> comboBoxActionPerformed());
        calculateButton.addActionListener(actionEvent -> calculateActionPerformed());

        solids = new Solid[6];
        solids[0] = new Sphere(1, 2);
        solids[1] = new Plate(3, 4);
        solids[2] = new Cone(3, 4);
        solids[3] = new Cylinder(3, 5);
        solids[4] = new Pipe(2, 4, 2);
        solids[5] = new Cuboid(3, 4, 1);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        picturePanel = new PaintPanel();
    }


    private void frameOpened() {
        String[] n = {"Name", "Value"};
        model = new DefaultTableModel(null, n);
        table1.setModel(model);
        table1.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        comboBox1.setSelectedIndex(0);
        calculateActionPerformed();
    }

    private void comboBoxActionPerformed() {
        int idx = comboBox1.getSelectedIndex();
        String s = String.format("/resource/%d.png", idx + 1);
        URL imageURL = MainForm.class.getResource(s);
        if (imageURL != null) {
            ImageIcon im = new ImageIcon(imageURL);
            ((PaintPanel) picturePanel).AssignRys(im.getImage());
        }
        picturePanel.repaint();
        solids[idx].showData(table1, model);
    }

    private void calculateActionPerformed() {
        int idx = comboBox1.getSelectedIndex();
        solids[idx].getData(table1);
        resultLabel.setText(
                String.format("I = %8.3f", solids[idx].momentOfInteria())
        );
    }
}
