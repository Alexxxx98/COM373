import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;



import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


    public class MyControlPanel extends JPanel
    {
    JPanel topPanel;
    JPanel leftPanel;
    JPanel rightPanel;
    JPanel centerPanel;
    JTextField deposit;
    JTextField withdraw;
    JTextField balance;
    JTextField max;
    JTextField min;
    JTextField maxD;
    JTextField minD;
    JLabel initBal;
    JLabel maxBal;
    JLabel minBal;
    JLabel maxDate;
    JLabel minDate;
    JButton initialBalance;
    JButton simulate;
    JButton stopSim;
    JButton showBal;
    JMenuBar theMenu;
    JMenu Account;
    JMenuItem Current;
    JMenuItem Savings;
    
    
        public MyControlPanel()
        {
        setLayout(new BorderLayout());
        this.add(getHeader(), BorderLayout.PAGE_START);
        this.add(getLeft(), BorderLayout.LINE_START);
        this.add(getCenter(), BorderLayout.CENTER);
        this.add(getRight(), BorderLayout.LINE_END);
        //this.add(getBottom(), BorderLayout.PAGE_END); 
        }

        protected JComponent getHeader() 
        {
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        theMenu = new JMenuBar();
        Account = new JMenu("Account Type");

        Current = new JMenuItem("Current");
        /*Current.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
             {
                 System.out.println("uhfdaoiuh");         
             }
        });*/

        Savings = new JMenuItem("Savings");

        Account.add(Current);
        Account.add(Savings);

        theMenu.add(Account);
        topPanel.add(theMenu, BorderLayout.WEST);
        
        topPanel.setBackground(Color.YELLOW);
        return topPanel;
        } 

        protected JComponent getLeft() 
        {
           leftPanel = new JPanel();
           leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

           leftPanel.add(Box.createRigidArea(new Dimension(5,50)));
           initBal = new JLabel("Please enter initial Balance of account");
           balance = new JTextField(10);
           initialBalance = new JButton("Submit");          
           balance.setMaximumSize(balance.getPreferredSize());
           simulate = new JButton("Start Simulation");    
           stopSim = new JButton("Stop Simulation");
           
           leftPanel.add(initBal);
           leftPanel.add(Box.createRigidArea(new Dimension(5,10)));
           leftPanel.add(balance);      
           leftPanel.add(Box.createRigidArea(new Dimension(5,10)));
           leftPanel.add(initialBalance);
           leftPanel.add(Box.createRigidArea(new Dimension(5,15)));
           leftPanel.add(simulate);
           leftPanel.add(Box.createRigidArea(new Dimension(5,15)));
           leftPanel.add(stopSim);
           leftPanel.setBackground(Color.YELLOW);
           return leftPanel;
        }

        protected JComponent getRight()
        {
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        maxBal = new JLabel("Maxium Balance During Simulation");
        minBal = new JLabel("Minimum Balance During Simulation");
        maxDate = new JLabel("Date Occured");
        minDate = new JLabel("Date Occured");
        
        max = new JTextField(15);
        max.setMaximumSize(max.getPreferredSize());
        min = new JTextField(15);
        min.setMaximumSize(min.getPreferredSize());
        maxD = new JTextField(15);
        maxD.setMaximumSize(maxD.getPreferredSize());
        minD = new JTextField(15);
        minD.setMaximumSize(maxD.getPreferredSize());
        

        rightPanel.add(maxBal);
        rightPanel.add(max);
        rightPanel.add(maxDate);
        rightPanel.add(maxD);
        rightPanel.add(Box.createRigidArea(new Dimension(5,15)));
        rightPanel.add(minBal);
        rightPanel.add(min);
        rightPanel.add(minDate);
        rightPanel.add(minD);  
        rightPanel.setBackground(Color.YELLOW);
        return rightPanel;
        }

        protected JComponent getCenter()
        {
        centerPanel = new JPanel();
        centerPanel.setBackground(Color.YELLOW);
        return centerPanel;
        }
}
