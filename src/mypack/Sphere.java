package mypack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Sphere extends Solid {
    protected int R;

    public Sphere(int Mass, int R){
        super(Mass);
        this.R = R;

    }

    @Override
    double momentOfInteria() {
        return 0.4 * Mass * R * R;
    }

    @Override
    void getData(JTable tab) {
        Mass= Integer.parseInt(tab.getValueAt(0, 1).toString());
        R = Integer.parseInt(tab.getValueAt(1, 1).toString());
    }

    @Override
    void showData(JTable tab, DefaultTableModel mod) {
        mod.setRowCount(2);
        tab.setValueAt("Mass", 0, 0);
        tab.setValueAt(Mass, 0, 1);
        tab.setValueAt("Radius", 1, 0);
        tab.setValueAt(R, 1, 1);
    }
}
