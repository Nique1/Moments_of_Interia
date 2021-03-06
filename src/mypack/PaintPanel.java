package mypack;

import javax.swing.*;
import java.awt.*;

public class PaintPanel extends JPanel {
    private int Width;
    private int Height;
    private Image rys;

    public PaintPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        Width = 320;
        Height = 360;
        rys = null;
    }

    public void AssignRys(Image xrys){
        rys = xrys;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(320,360);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(0,0,Width,Height);
        if(rys!=null)
            g.drawImage(rys,0,0,this);
    }
}
