package mypack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Pipe extends Cylinder{
    protected int r;

    public Pipe(int Mass, int R, int r) {
        super(Mass, R);
        this.r = r;
    }

    @Override
    double momentOfInteria() {
        return Mass*(R*R+r*r)/2;
    }

    @Override
    void getData(JTable tab) {
        super.getData(tab);
    }

    @Override
    void showData(JTable tab, DefaultTableModel mod) {
        super.showData(tab, mod);
    }
}
