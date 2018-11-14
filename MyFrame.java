import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;

public class MyFrame extends JFrame 
{
    
    public MyFrame()
    {
        
    MyControlPanel myPane = new MyControlPanel();
    this.add(myPane);
    myPane.setLayout(null);

    JMenuBar theMenu = new JMenuBar();
    JMenu Account = new JMenu("Account Type");

    JMenuItem Current = new JMenuItem("Current");
    JMenuItem Savings = new JMenuItem("Savings");


    Account.add(Current);
    Account.add(Savings);

    theMenu.add(Account);
    this.setJMenuBar(theMenu);

    } 
}

