package mypack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public abstract class Solid {
    protected int Mass;

    public Solid(int Mass) {
        this.Mass = Mass;
    }


    abstract double momentOfInteria();
    abstract void getData(JTable tab);
    abstract void showData(JTable tab, DefaultTableModel mod);

}
