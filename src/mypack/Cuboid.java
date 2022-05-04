package mypack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Cuboid extends Solid{
    protected int a;
    protected int b;

    public Cuboid(int Mass, int a, int b) {
        super(Mass);
        this.a = a;
        this.b = b;
    }

    @Override
    double momentOfInteria() {
        return 1.0 / 12 * Mass * (a * a + b * b);
    }

    @Override
    void getData(JTable tab) {
        Mass = Integer.parseInt(tab.getValueAt(0, 1).toString());
        a = Integer.parseInt(tab.getValueAt(1, 1).toString());
        b = Integer.parseInt(tab.getValueAt(2, 1).toString());
    }

    @Override
    void showData(JTable tab, DefaultTableModel mod) {
        mod.setRowCount(3);
        tab.setValueAt("Mass", 0, 0);
        tab.setValueAt(Mass, 0, 1);

        tab.setValueAt("Length", 1, 0);
        tab.setValueAt(a, 1, 1);

        tab.setValueAt("Width",2,0 );
        tab.setValueAt(b, 2, 1);
    }
}
