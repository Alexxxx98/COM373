
import java.awt.Color;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

public class MyFrame extends JFrame
{

    public MyFrame()
    {
        
    this.setTitle("Account Simulation");
    this.setSize(1400,800);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel main = new JPanel();
    main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
    main.setBackground(Color.YELLOW);

    main.add(new MyControlPanel());
    main.add(new MyDrawingPanel());
   
    this.add(main);
    this.setBackground(Color.yellow);
    this.setVisible(true);
    }
}

