

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Graph extends JPanel
{

    int x, y;
    
    public Graph()
    {
        this.setSize (400, 300);
        
        this.setVisible (true);
        x =30;
        y = 300;
    }
    
    public void drawAxes (Graphics g)
    {
        g.drawLine(330, 30, 300, 600);
        g.setColor(Color.BLACK);
        g.drawLine(330, 30, 600, 300);
        g.fillOval(x, y, 3, 3);

    }

}
